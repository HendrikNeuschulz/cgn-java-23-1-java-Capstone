package com.github.hendrikneuschulz.backend.controller;

import com.github.hendrikneuschulz.backend.model.Recipe;
import com.github.hendrikneuschulz.backend.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class RecipeControllerTest {
    private RecipeService recipeServiceMock;
    private RecipeController recipeController;

    @BeforeEach
    public void setUp() {
        recipeServiceMock = mock(RecipeService.class);
        recipeController = new RecipeController(recipeServiceMock);
    }

    @Test
    void testGetRecipes() {
        Recipe recipe1 = new Recipe("Recipe 1");
        Recipe recipe2 = new Recipe("Recipe 2");

        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe1);
        recipeList.add(recipe2);
        when(recipeServiceMock.getRecipeList()).thenReturn(recipeList);

        List<Recipe> result = recipeController.getRecipes();

        assertEquals(recipeList, result);
        verify(recipeServiceMock, times(1)).getRecipeList();
    }

    @Test
    void testGetRandomRecipe() {
        Recipe randomRecipe = new Recipe("Random Recipe");
        when(recipeServiceMock.getRandomRecipe()).thenReturn(randomRecipe);

        Recipe result = recipeController.getRandomRecipe();

        assertNotNull(result);
        assertEquals(randomRecipe.getName(), result.getName());
        verify(recipeServiceMock, times(1)).getRandomRecipe();
    }
}