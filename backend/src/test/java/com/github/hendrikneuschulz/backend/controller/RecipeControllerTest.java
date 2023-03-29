package com.github.hendrikneuschulz.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.hendrikneuschulz.backend.model.Recipe;
import com.github.hendrikneuschulz.backend.repository.RecipeRepository;
import com.github.hendrikneuschulz.backend.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
class RecipeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    RecipeRepository recipeRepository;

    @MockBean
    RecipeService recipeService;

    ObjectMapper objectMapper = new ObjectMapper();

    Recipe recipe = new Recipe("Bratwurst");


    @BeforeEach
    void setUp() {
        recipeRepository.save(recipe);
    }

    @Test
    void whenGetAllRecipes_ThenReturnListOfAllRecipes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/wtf/recipes"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

    @Test
    void whenGetRandomRecipes_ThenReturnOneRandomRecipes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/wtf/recipes/random"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.name").isNotEmpty())
                .andExpect(jsonPath("$.category").isNotEmpty())
                .andExpect(jsonPath("$.instruction").isNotEmpty())
                .andExpect(jsonPath("$.image").isNotEmpty())
                .andExpect(jsonPath("$.youtube").isNotEmpty())
                .andExpect(jsonPath("$.measure").isNotEmpty())
                .andExpect(jsonPath("$.ingredients").isNotEmpty())
                .andExpect(jsonPath("$.likedby").isNotEmpty())
                .andExpect(jsonPath("$.comments").isNotEmpty());

    }

    @Test
    void whenAddRecipes_ThenReturnRecipes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/wtf/recipes/add"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(""));
    }
}