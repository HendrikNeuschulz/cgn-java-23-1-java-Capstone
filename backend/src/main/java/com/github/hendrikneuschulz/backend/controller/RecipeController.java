package com.github.hendrikneuschulz.backend.controller;

import com.github.hendrikneuschulz.backend.model.Recipe;
import com.github.hendrikneuschulz.backend.service.RecipeService;
import org.springframework.web.bind.annotation.*;

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
        return recipeService.getRandomRecipe();
    }

    @PostMapping("/add")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }

}
