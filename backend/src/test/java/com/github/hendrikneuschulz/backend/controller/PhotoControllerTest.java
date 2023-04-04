package com.github.hendrikneuschulz.backend.controller;

import com.github.hendrikneuschulz.backend.service.PhotoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;

@WebMvcTest(controllers = PhotoController.class)
public class PhotoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PhotoService photoService;

    private MockMultipartFile mockMultipartFile;

    @BeforeEach
    public void setUp() {
        mockMultipartFile = new MockMultipartFile(
                "file",
                "test.jpg",
                "image/jpeg",
                "test image".getBytes()
        );
    }

    @Test
    public void shouldUploadPhoto() throws Exception {
        String expectedResponse = "http://example.com/test.jpg";

        when(photoService.uploadImage(mockMultipartFile)).thenReturn(expectedResponse);

        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/wtf/recipes/upload")
                        .file(mockMultipartFile))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedResponse));
    }
}