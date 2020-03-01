package com.wlq.controller;

import com.wlq.constant.ClientExceptionConstant;
import com.wlq.exception.ClientException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-26-16:12
 */
@CrossOrigin
@RestController
@RequestMapping("/image")
public class ImageController {

    private List<String> imageExts = Arrays.asList("jpg","jpeg","png");

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile image) throws IOException, ClientException{
        String originalFilename = image.getOriginalFilename();
        String[] splits = originalFilename.split("\\.");
        String ext = splits[splits.length-1];
        ext = ext.toLowerCase();
        boolean contains = imageExts.contains(ext);
        if (!contains){
            throw new ClientException(ClientExceptionConstant.IMAGE_INVALID_ERRCODE,ClientExceptionConstant.IMAGE_INVALID_ERRMSG);
        }
        String uuid = UUID.randomUUID().toString();
        String filename = String.format("%s.%s", uuid, ext);
        String filepath = String.format("C:/Users/WangLanqing/Desktop/pic/%s", filename);
        try(FileOutputStream out = new FileOutputStream(filepath)) {
        byte[] data = image.getBytes();
        out.write(data);
    }

        return filename;
    }
}
