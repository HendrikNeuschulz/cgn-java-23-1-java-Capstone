package com.github.hendrikneuschulz.backend.service;

import com.github.hendrikneuschulz.backend.model.Recipe;
import com.github.hendrikneuschulz.backend.model.RecipeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PhotoServiceTest {

    PhotoService photoService = mock(PhotoService.class);
    MultipartFile multipartFile = mock(MultipartFile.class);

    @Test
    void testUploadImage() throws IOException {
        RecipeDTO recipeImageUpload = RecipeDTO.builder().name("Test Recipe").build();
        Recipe recipe = new Recipe(recipeImageUpload);

        when(photoService.uploadImage(multipartFile)).thenReturn(recipe.getImage());
        String actual = photoService.uploadImage(multipartFile);
        assertEquals(recipe.getImage(), actual);

    }

}
