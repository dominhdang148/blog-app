package com.dominhdang.blog_app.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Pagination {
    private int currentPage;
    private int pageSize;
    private int totalPages;
    private long totalItems;
}
