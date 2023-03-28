package com.github.hendrikneuschulz.backend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("recipes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Recipe {
    String id;
    String name;
    String category;
    String instructions;
    String image;
    String youtube;
    private List<String> measure;
    private List<String> ingredients;
    private List<String> likedby;
    private List<String> comments;

    public Recipe(String name) {
        this.name = name;
    }
}
