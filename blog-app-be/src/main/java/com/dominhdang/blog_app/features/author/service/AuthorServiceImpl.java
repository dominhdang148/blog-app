package com.dominhdang.blog_app.features.author.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dominhdang.blog_app.features.author.dto.AuthorDetailDto;
import com.dominhdang.blog_app.features.author.dto.AuthorFormDto;
import com.dominhdang.blog_app.features.author.dto.AuthorItemDto;
import com.dominhdang.blog_app.features.author.dto.mapper.AuthorMapper;
import com.dominhdang.blog_app.features.author.entity.Author;
import com.dominhdang.blog_app.features.author.repository.AuthorRepository;
import com.dominhdang.blog_app.features.images.service.ImageService;
import com.dominhdang.blog_app.models.ApiResponse;
import com.dominhdang.blog_app.models.Pagination;

import jakarta.transaction.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private ImageService imageService;

    @Override
    public ApiResponse<AuthorDetailDto> saveAuthor(AuthorFormDto author) {
        Author savedAuthor = authorRepository
                .save(authorMapper.toEntity(author));

        return ApiResponse.<AuthorDetailDto>builder()
                .data(authorMapper.toDetailDto(savedAuthor))
                .status(HttpStatus.CREATED)
                .message("Saved Author successfully")
                .build();
    }

    @Override
    public ApiResponse<AuthorDetailDto> saveAuthor(UUID id, AuthorFormDto author) {
        if (authorRepository.existsById(id)) {
            Author updatedAuthor = this.authorRepository.findById(id).get();
            updatedAuthor.setFullName(author.getFullName());
            updatedAuthor.setUrlSlug(author.getUrlSlug());
            updatedAuthor.setEmail(author.getEmail());
            updatedAuthor.setNote(author.getNote());
            return ApiResponse.<AuthorDetailDto>builder()
                    .status(HttpStatus.OK)
                    .data(this.authorMapper.toDetailDto(this.authorRepository.save(updatedAuthor)))
                    .message(String.format("Author with id: %s updated succesfully", id))
                    .build();
        }
        return ApiResponse.<AuthorDetailDto>builder()
                .message(String.format("Author with id: %s not found", id))
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    @Override
    @Transactional
    public ApiResponse<AuthorDetailDto> updateAvatar(UUID id, MultipartFile image) {
        Author author = authorRepository.findById(id).orElse(null);

        if (author != null) {
            try {
                String imageUrl = imageService.saveImage(image);
                author.setImageUrl(imageUrl);
                return ApiResponse.<AuthorDetailDto>builder()
                        .data(this.authorMapper.toDetailDto(this.authorRepository.save(author)))
                        .message(String.format("Author with id: %s updated succesfully", id))
                        .status(HttpStatus.OK)
                        .build();

            } catch (Exception e) {
                return ApiResponse.<AuthorDetailDto>builder()
                        .message(String.format("There is error while saving image: %s", e.getMessage()))
                        .status(HttpStatus.BAD_REQUEST)
                        .build();
            }
        }

        return ApiResponse.<AuthorDetailDto>builder()
                .message(String.format("Author with id: %s not found", id))
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    @Override
    public ApiResponse<List<AuthorItemDto>> getAllByName(String name, int currentPage, int pageSize) {

        Pageable pageable = PageRequest.of(currentPage, pageSize);
        Page<AuthorItemDto> results = authorRepository.findByFullNameContainingIgnoreCase(name, pageable)
                .map(author -> authorMapper.toItemDto(author));
        Pagination pagination = Pagination.builder().currentPage(currentPage).pageSize(pageSize)
                .totalItems(results.getTotalElements()).totalPages(results.getTotalPages()).build();
        return ApiResponse.<List<AuthorItemDto>>builder()
                .data(results.toList())
                .message("Get Author list successfully")
                .status(HttpStatus.OK)
                .pagination(pagination)
                .build();

    }

    @Override
    public ApiResponse<AuthorDetailDto> getById(UUID id) {

        Author data = this.authorRepository.findById(id).orElse(null);
        if (data == null) {
            return ApiResponse.<AuthorDetailDto>builder().status(HttpStatus.NOT_FOUND)
                    .message(String.format("Author with id: %s not exists", id)).build();

        }
        return ApiResponse.<AuthorDetailDto>builder().status(HttpStatus.OK)
                .data(this.authorMapper.toDetailDto(data))
                .message(String.format("Author with id: %s found successfully", id)).build();
    }

    @Override
    public ApiResponse<?> deleteById(UUID id) {

        if (authorRepository.existsById(id)) {
            this.authorRepository.deleteById(id);
            return ApiResponse.builder().status(HttpStatus.OK)
                    .message(String.format("Author with id: %s deleted successfully", id)).build();
        }
        return ApiResponse.builder().status(HttpStatus.NOT_FOUND)
                .message(String.format("Author with id: %s not found", id)).build();
    }
}
