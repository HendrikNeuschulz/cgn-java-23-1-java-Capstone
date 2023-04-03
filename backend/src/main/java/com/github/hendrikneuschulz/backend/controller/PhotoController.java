package com.github.hendrikneuschulz.backend.controller;

import com.github.hendrikneuschulz.backend.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/wtf/recipes/upload")
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoService photoService;

    @PostMapping
    public String uploadPhoto(@RequestParam("file") MultipartFile photo) throws IOException {
        return photoService.uploadPhoto(photo);
    }

}