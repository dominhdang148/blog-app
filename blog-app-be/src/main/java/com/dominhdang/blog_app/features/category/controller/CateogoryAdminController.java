package com.dominhdang.blog_app.features.category.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/admin/category")
@Tag(name = "Category Admin Endpoints", description = "Category's endpoints for administrator access")
public class CateogoryAdminController {

}
