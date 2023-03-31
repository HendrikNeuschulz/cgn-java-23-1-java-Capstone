package com.github.hendrikneuschulz.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class RecipeDTO {
    String name;
    String category;
    String instructions;
    String image;
    String youtubeUrl;
    List<String> measure;
    List<String> ingredients;

}

