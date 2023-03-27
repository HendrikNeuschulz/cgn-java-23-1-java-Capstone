package com.github.hendrikneuschulz.backend.service;

import com.github.hendrikneuschulz.backend.model.Recipe;
import com.github.hendrikneuschulz.backend.repository.RecipeRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RecipeServiceTest {
    @Test
    void testGetRecipeList() {

        RecipeRepository recipeRepository = mock(RecipeRepository.class);
        List<Recipe> mockRecipes = new ArrayList<>();
        mockRecipes.add(new Recipe("Recipe 1"));
        mockRecipes.add(new Recipe("Recipe 2"));
        when(recipeRepository.findAll()).thenReturn(mockRecipes);


        RecipeService recipeService = new RecipeService(recipeRepository);

        List<Recipe> recipeList = recipeService.getRecipeList();
        assertEquals(2, recipeList.size());
        assertEquals("Recipe 1", recipeList.get(0).getName());
        assertEquals("Recipe 2", recipeList.get(1).getName());
    }

    @Test
    void testGetRandomRecipe() {

        RecipeRepository recipeRepository = mock(RecipeRepository.class);
        List<Recipe> recipeList = Arrays.asList(
                new Recipe("Recipe 1"),
                new Recipe("Recipe 2"),
                new Recipe("Recipe 3")
        );
        when(recipeRepository.findAll()).thenReturn(recipeList);

        RecipeService recipeService = new RecipeService(recipeRepository);

        Recipe randomRecipe = recipeService.getRandomRecipe();
        assertNotNull(randomRecipe);
        assertTrue(recipeList.contains(randomRecipe));
    }
}

