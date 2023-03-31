package com.github.hendrikneuschulz.backend.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("recipes")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Recipe {
    String id;
    String name;
    String category;
    String instructions;
    String image;
    String youtubeUrl;
    List<String> measure;
    List<String> ingredients;
    List<String> likedby;
    List<String> comments;

    public Recipe(RecipeDTO recipeToAdd) {
        this.name = recipeToAdd.getName();
        this.category = recipeToAdd.getCategory();
        this.instructions = recipeToAdd.getInstructions();
        this.image = recipeToAdd.getImage();
        this.youtubeUrl = recipeToAdd.getYoutubeUrl();
        this.measure = recipeToAdd.getMeasure();
        this.ingredients = recipeToAdd.getIngredients();
    }
}



