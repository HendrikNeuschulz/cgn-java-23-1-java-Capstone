package com.github.hendrikneuschulz.backend.controller;

import com.github.hendrikneuschulz.backend.model.Recipe;
import com.github.hendrikneuschulz.backend.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class RecipeControllerTest {
    private RecipeService recipeServiceMock;
    private RecipeController recipeController;

    @BeforeEach
    public void setUp() {
        recipeServiceMock = mock(RecipeService.class);
        recipeController = new RecipeController(recipeServiceMock);
    }

    String id = "1234";
    String name = "Pasta with Tomato Sauce";
    String category = "Italian";
    String instructions = "1. Cook the pasta in a large pot of boiling salted water until al dente. 2. Meanwhile, heat the olive oil in a large, heavy skillet over medium heat. 3. Add the garlic and sauté until fragrant, about 1 minute. 4. Add the tomatoes and cook until they start to soften, about 5 minutes. 5. Season with salt and red pepper flakes to taste. 6. Drain the pasta and add it to the skillet with the tomato sauce. 7. Toss to coat the pasta with the sauce. 8. Serve hot, garnished with Parmesan cheese, if desired.";
    String image = "https://example.com/images/pasta.jpg";
    String youtube = "https://www.youtube.com/watch?v=dQw4w9WgXcQ";
    String[] measure = {"1 pound", "2 cloves", "1 can (28 ounces)", "1/4 teaspoon", "1/4 teaspoon", "1/4 teaspoon", "1/4 teaspoon", "1/4 teaspoon", "1/4 teaspoon", "1/4 teaspoon", "1/4 teaspoon", "1/4 teaspoon", "1/4 teaspoon"};
    String[] ingredients = {"spaghetti", "garlic, minced", "diced tomatoes", "salt", "black pepper", "crushed red pepper flakes", "dried oregano", "dried basil", "sugar", "olive oil", "grated Parmesan cheese", "chopped fresh parsley leaves"};
    String[] likedby = {"user1", "user2", "user3"};
    String[] comments = {"This recipe is amazing!", "I loved it", "I added some mushrooms and it was great"};
    @Test
    public void testGetRecipes() {
        // Setup
        Recipe recipe1= new Recipe(id, name, category, instructions, image, youtube, measure, ingredients, likedby, comments);
        Recipe recipe2= new Recipe(id, name, category, instructions, image, youtube, measure, ingredients, likedby, comments);

        ArrayList<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe1);
        recipeList.add(recipe2);
        when(recipeServiceMock.getRecipeList()).thenReturn(recipeList);

        // Execute
        ArrayList<Recipe> result = recipeController.getRecipes();

        // Verify
        assertEquals(recipeList, result);
        verify(recipeServiceMock, times(1)).getRecipeList();
    }
}