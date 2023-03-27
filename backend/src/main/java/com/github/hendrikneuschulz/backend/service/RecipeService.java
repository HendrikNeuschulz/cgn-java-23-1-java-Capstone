package com.github.hendrikneuschulz.backend.service;

import com.github.hendrikneuschulz.backend.model.Recipe;
import com.github.hendrikneuschulz.backend.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    public List<Recipe> getRecipeList() {
        List<Recipe> recipeList = recipeRepository.findAll();
        return new ArrayList<>(recipeList);
    }


}