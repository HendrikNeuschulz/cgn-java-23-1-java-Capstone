package com.github.hendrikneuschulz.backend.controller;

import com.github.hendrikneuschulz.backend.model.MongoUser;
import com.github.hendrikneuschulz.backend.repository.MongoUserRepository;
import com.github.hendrikneuschulz.backend.repository.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
class RecipeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    MongoUserRepository mongoUserRepository;


    @Test
    void whenGetAllRecipes_ThenReturnListOfAllRecipes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/wtf/recipes"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

    @Test
    @WithMockUser(username = "testuser", password = "testpassword")
    @DirtiesContext
    void whenGetRandomRecipes_ThenReturnOneRandomRecipes() throws Exception {
        mongoUserRepository.save(new MongoUser("111", "user", "123", "BASIC"));
        mockMvc.perform(MockMvcRequestBuilders.post("/api/wtf/recipes/add")
                .contentType("application/json")
                .content("""
                            {
                                "id": "id",
                                "name": "name",
                                "category": "category",
                                "instructions": "instruction",
                                "image": "image",
                                "youtubeUrl": "youtube",
                                "measure": ["Abc"],
                                "ingredients": ["Abc"]
                            }
                        """).with(csrf())
        );


        mockMvc.perform(MockMvcRequestBuilders.get("/api/wtf/recipes/random"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.name").isNotEmpty())
                .andExpect(jsonPath("$.category").isNotEmpty())
                .andExpect(jsonPath("$.instructions").isNotEmpty())
                .andExpect(jsonPath("$.image").isNotEmpty())
                .andExpect(jsonPath("$.youtubeUrl").isNotEmpty())
                .andExpect(jsonPath("$.measure").isArray())
                .andExpect(jsonPath("$.ingredients").isArray())
                .andReturn();
    }
}