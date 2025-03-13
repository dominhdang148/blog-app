package com.dominhdang.blog_app.features.tag.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "api/admin/tag")
@Tag(name = "Tag Admin Endpoints", description = "Tag's endpoints for administrator access")
public class TagAdminController {

}
