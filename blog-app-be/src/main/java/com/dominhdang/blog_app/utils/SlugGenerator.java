package com.dominhdang.blog_app.utils;

import java.text.Normalizer;

public class SlugGenerator {

    public static String toSlug(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        // Normalize to remove accents
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");

        // Replace non-alphanumeric characters with spaces
        String slug = normalized.replaceAll("[^a-zA-Z0-9\\s-]", "").toLowerCase();

        // Replace spaces and multiple hyphens with a single hyphen
        slug = slug.replaceAll("\\s+", "-").replaceAll("-{2,}", "-");

        // Trim leading and trailing hyphens
        return slug.replaceAll("^-|-$", "");
    }
}
