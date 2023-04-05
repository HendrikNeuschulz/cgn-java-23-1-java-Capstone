package com.github.hendrikneuschulz.backend.service;

import com.github.hendrikneuschulz.backend.model.Recipe;
import com.github.hendrikneuschulz.backend.repository.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PhotoServiceTest {

    PhotoService photoService = mock(PhotoService.class);
    MultipartFile multipartFile = mock(MultipartFile.class);

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

    @Test
    void testUploadImage() throws IOException {
        File fileToUpload = File.createTempFile("image", null);
        multipartFile.transferTo(fileToUpload);

        when(photoService.uploadImage(multipartFile)).thenReturn(recipe.getImage());
        String actual = photoService.uploadImage(multipartFile);
        assertEquals(recipe.getImage(), actual);

    }

}
