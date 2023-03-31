package com.github.hendrikneuschulz.backend.controller;

import com.github.hendrikneuschulz.backend.repository.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
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


    @Test
    void whenGetAllRecipes_ThenReturnListOfAllRecipes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/wtf/recipes"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

    @Test
    @DirtiesContext
    void whenGetRandomRecipes_ThenReturnOneRandomRecipes() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post(
                        "/api/wtf/recipes/add")
                .contentType("application/json")
                .content("""
                                                {
                                                    "id": "id",
                                                    "name": "name",
                                                    "category": "category",
                                                    "instructions": "instruction",
                                                    "image": "image",
                                                    "youtube": "youtube",
                                                    "measure": ["Abc"],
                                                    "ingredients": ["Abc"]
                                                   
                                                }
                                                
                        """)
        );

        var response = mockMvc.perform(MockMvcRequestBuilders.get("/api/wtf/recipes/random"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.id").isNotEmpty())
                .andExpect(jsonPath("$.name").isNotEmpty())
                .andExpect(jsonPath("$.category").isNotEmpty())
                .andExpect(jsonPath("$.instructions").isNotEmpty())
                .andExpect(jsonPath("$.image").isNotEmpty())
                .andExpect(jsonPath("$.youtube").isNotEmpty())
                .andExpect(jsonPath("$.measure").isArray())
                .andExpect(jsonPath("$.ingredients").isArray())

                .andReturn();
        System.out.println(response);

    }
    
}