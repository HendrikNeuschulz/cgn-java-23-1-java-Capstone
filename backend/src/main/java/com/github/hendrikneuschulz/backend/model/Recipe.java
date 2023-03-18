package com.github.hendrikneuschulz.backend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

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
    String[] measure;
    String[] ingredients;
    String[] likedby;
    String[] comments;
}
