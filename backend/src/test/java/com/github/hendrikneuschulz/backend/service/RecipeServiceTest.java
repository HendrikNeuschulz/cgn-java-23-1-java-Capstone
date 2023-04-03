package com.github.hendrikneuschulz.backend.service;

import com.cloudinary.Cloudinary;
import com.github.hendrikneuschulz.backend.model.Recipe;
import com.github.hendrikneuschulz.backend.model.RecipeDTO;
import com.github.hendrikneuschulz.backend.repository.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceTest {

    RecipeRepository recipeRepositoryMock = mock(RecipeRepository.class);
    IdService idServiceMock = mock(IdService.class);
    RecipeService recipeService = new RecipeService(recipeRepositoryMock, idServiceMock);

    Recipe recipe = Recipe.builder()
            .name("Recipe 1")
            .category("Test")
            .instructions("Test")
            .image("Test")
            .youtubeUrl("Test")
            .measure(List.of("Test"))
            .ingredients(List.of("Test"))
            .build();

    Recipe recipe2 = Recipe.builder()
            .name("Recipe 2")
            .category("Test")
            .instructions("Test")
            .image("Test")
            .youtubeUrl("Test")
            .measure(List.of("Test"))
            .ingredients(List.of("Test"))
            .build();

    Cloudinary cloudinaryMock = Mockito.mock(Cloudinary.class);
    PhotoService photoService = new PhotoService(cloudinaryMock);

    @Test
    void testGetRecipeList() {


        RecipeRepository recipeRepository = mock(RecipeRepository.class);
        List<Recipe> mockRecipes = new ArrayList<>();

        mockRecipes.add(recipe);
        mockRecipes.add(recipe2);
        when(recipeRepository.findAll()).thenReturn(mockRecipes);


        RecipeService recipeService = new RecipeService(recipeRepository, null);

        List<Recipe> recipeList = recipeService.getRecipeList();
        assertEquals(2, recipeList.size());
        assertEquals("Recipe 1", recipeList.get(0).getName());
        assertEquals("Recipe 2", recipeList.get(1).getName());
    }

    @Test
    void testGetRandomRecipe() {

        RecipeRepository recipeRepository = mock(RecipeRepository.class);
        List<Recipe> recipeList = Arrays.asList(
                recipe,
                recipe,
                recipe
        );
        when(recipeRepository.findAll()).thenReturn(recipeList);

        RecipeService recipeService = new RecipeService(recipeRepository, null);

        Recipe randomRecipe = recipeService.getRandomRecipe();
        assertNotNull(randomRecipe);
        assertTrue(recipeList.contains(randomRecipe));
    }

    @Test
    void testAddRecipe() {
        RecipeDTO recipeToAdd = RecipeDTO.builder().name("Test Recipe").build();
        Recipe recipe = new Recipe(recipeToAdd);

        when(idServiceMock.generateId()).thenReturn("123");
        recipe.setId("123");
        when(recipeRepositoryMock.save(recipe)).thenReturn(recipe);

        Recipe result = recipeService.addRecipe(recipeToAdd);

        assertNotNull(result);
        assertEquals("123", result.getId());
        assertEquals(recipeToAdd.getName(), result.getName());
        verify(idServiceMock, times(1)).generateId();
        verify(recipeRepositoryMock, times(1)).save(recipe);
    }


}