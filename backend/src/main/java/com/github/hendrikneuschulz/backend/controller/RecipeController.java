package com.github.hendrikneuschulz.backend.controller;

import com.github.hendrikneuschulz.backend.model.Recipe;
import com.github.hendrikneuschulz.backend.service.IdService;
import com.github.hendrikneuschulz.backend.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wtf/recipes")
public class RecipeController {
    private final RecipeService recipeService;
    private final IdService idService;


    public RecipeController(RecipeService recipeService, IdService idService) {
        this.recipeService = recipeService;
        this.idService = idService;
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
