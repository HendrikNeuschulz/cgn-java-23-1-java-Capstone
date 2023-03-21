package com.github.hendrikneuschulz.backend.service;

import com.github.hendrikneuschulz.backend.model.Recipe;
import com.github.hendrikneuschulz.backend.repository.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class RecipeServiceTest {
    @Test
    void testGetRecipeList() {

        RecipeRepository recipeRepository = Mockito.mock(RecipeRepository.class);
        List<Recipe> mockRecipes = new ArrayList<>();
        mockRecipes.add(new Recipe("Recipe 1"));
        mockRecipes.add(new Recipe("Recipe 2"));
        Mockito.when(recipeRepository.findAll()).thenReturn(mockRecipes);


        RecipeService recipeService = new RecipeService(recipeRepository);

        List<Recipe> recipeList = recipeService.getRecipeList();
        assertEquals(2, recipeList.size());
        assertEquals("Recipe 1", recipeList.get(0).getName());
        assertEquals("Recipe 2", recipeList.get(1).getName());
    }
}