package com.github.hendrikneuschulz.backend.service;

import com.github.hendrikneuschulz.backend.model.Recipe;
import com.github.hendrikneuschulz.backend.repository.RecipeRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getRecipeList() {
        List<Recipe> recipeList = recipeRepository.findAll();
        return new ArrayList<>(recipeList);
    }
}