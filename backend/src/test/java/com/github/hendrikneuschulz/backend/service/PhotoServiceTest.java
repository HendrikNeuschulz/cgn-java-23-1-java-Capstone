package com.github.hendrikneuschulz.backend.service;

import com.cloudinary.Cloudinary;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PhotoServiceTest {

    Cloudinary cloudinaryMock = mock(Cloudinary.class);

    PhotoService photoService = new PhotoService(cloudinaryMock);


    @Test
    void testUploadImageSuccess() throws IOException {
        MockMultipartFile multipartFile = new MockMultipartFile(
                "file",
                "test-image.jpg",
                "image/jpeg",
                "Test image content".getBytes()
        );

        Map<String, String> response = Map.of("url", "https://example.com/test-image.jpg");
        when(cloudinaryMock.uploader()).thenReturn(mock(com.cloudinary.Uploader.class));
        when(cloudinaryMock.uploader().upload(any(File.class), any(Map.class))).thenReturn(response);

        String actual = photoService.uploadImage(multipartFile);

        assertEquals("https://example.com/test-image.jpg", actual);
    }

    @Test
    void testUploadImageIOException() throws IOException {
        MockMultipartFile multipartFile = new MockMultipartFile(
                "file",
                "test-image.jpg",
                "image/jpeg",
                "Test image content".getBytes()
        );

        when(cloudinaryMock.uploader()).thenReturn(mock(com.cloudinary.Uploader.class));
        when(cloudinaryMock.uploader().upload(any(File.class), any(Map.class))).thenThrow(IOException.class);

        assertThrows(IOException.class, () -> photoService.uploadImage(multipartFile));
    }
}
