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
    String youtube;
    List<String> measure;
    List<String> ingredients;
    List<String> likedby;
    List<String> comments;

    public Recipe(RecipeDTO recipeRequestModel) {
        this.name = recipeRequestModel.getName();
        this.category = recipeRequestModel.getCategory();
        this.instructions = recipeRequestModel.getInstructions();
        this.image = recipeRequestModel.getImage();
        this.youtube = recipeRequestModel.getYoutube();
        this.measure = recipeRequestModel.getMeasure();
        this.ingredients = recipeRequestModel.getIngredients();
    }


}



