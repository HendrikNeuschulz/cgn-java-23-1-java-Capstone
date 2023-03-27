package com.github.hendrikneuschulz.backend.controller;

import com.github.hendrikneuschulz.backend.model.Recipe;
import com.github.hendrikneuschulz.backend.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;
import java.util.List;

@RestController
@RequestMapping("/api/wtf/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getRecipes() {
        return recipeService.getRecipeList();
    }

    @GetMapping("/random")
    public Recipe getRandomRecipe() {
        List<Recipe> recipeList = recipeService.getRecipeList();
        int randomIndex = new SecureRandom().nextInt(recipeList.size());
        return recipeList.get(randomIndex);
    }


}
