package com.wlq.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-26-16:12
 */
@RestController
@RequestMapping("/image")
public class ImageController {

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile image){
        return null;
    }
}
