package com.github.hendrikneuschulz.backend.controller;

import com.github.hendrikneuschulz.backend.model.MongoUser;
import com.github.hendrikneuschulz.backend.repository.MongoUserRepository;
import com.github.hendrikneuschulz.backend.service.PhotoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;


@SpringBootTest
@AutoConfigureMockMvc
class PhotoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    MongoUserRepository mongoUserRepository;

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
    @WithMockUser(username = "user", password = "123")
    @DirtiesContext
    void shouldUploadPhoto() throws Exception {
        mongoUserRepository.save(new MongoUser("111", "user", "123", "BASIC"));

        String expectedResponse = "http://example.com/test.jpg";

        when(photoService.uploadImage(mockMultipartFile)).thenReturn(expectedResponse);


        mockMvc.perform(MockMvcRequestBuilders.multipart("/api/wtf/recipes/upload")
                        .file(mockMultipartFile).with(csrf()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedResponse));
    }
}