package com.github.hendrikneuschulz.backend.service;

import com.cloudinary.Cloudinary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class PhotoService {

    private final Cloudinary cloudinary;

    public PhotoService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;

    }

    public String uploadImage(MultipartFile image) throws IOException {
        File fileToUpload = File.createTempFile("image", null);
        image.transferTo(fileToUpload);
        Map<String, Object> response = cloudinary.uploader().upload(fileToUpload, Map.of());
        return response.get("url").toString();
    }
}
