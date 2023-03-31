package com.github.hendrikneuschulz.backend.service;

import com.github.hendrikneuschulz.backend.model.Recipe;
import com.github.hendrikneuschulz.backend.model.RecipeDTO;
import com.github.hendrikneuschulz.backend.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IdService idService;

    public RecipeService(RecipeRepository recipeRepository, IdService idService) {
        this.recipeRepository = recipeRepository;
        this.idService = idService;
    }

    public List<Recipe> getRecipeList() {
        return recipeRepository.findAll();
    }

    public Recipe getRandomRecipe() {
        List<Recipe> recipeList = recipeRepository.findAll();
        if (!recipeList.isEmpty()) {
            int randomIndex = ThreadLocalRandom.current().nextInt(recipeList.size());
            return recipeList.get(randomIndex);
        }
        return null;
    }

    public Recipe addRecipe(RecipeDTO recipeToAdd) {
        Recipe recipe = new Recipe(recipeToAdd);
        recipe.setId(idService.generateId());
        return recipeRepository.save(recipe);
    }
}