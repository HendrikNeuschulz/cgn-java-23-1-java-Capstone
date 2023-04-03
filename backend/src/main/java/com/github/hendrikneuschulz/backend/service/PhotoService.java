package com.github.hendrikneuschulz.backend.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class PhotoService {

    private final Cloudinary cloudinary;

    public PhotoService() {
        Map config = new HashMap<>();
        config.put("cloud_name", "dffgmmeaj");
        config.put("api_key", "366892173562838");
        config.put("api_secret", "M0fquSV9d2OpBNENoDxQbhi9JJ4");
        cloudinary = new Cloudinary(config);
    }

    public String uploadPhoto(MultipartFile photo) throws IOException {
        Map result = cloudinary.uploader().upload(photo.getBytes(), ObjectUtils.emptyMap());
        return result.get("url").toString();
    }
}
