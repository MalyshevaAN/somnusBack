package image.example.nastia.controllers;


import image.example.nastia.Service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ProductImageController {

    @Autowired
    ProductImageService service;

    @PostMapping("/upload")
    public void uploadImage(@RequestParam("productImage")MultipartFile file) throws IOException {
        service.uploadImage(file);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> ResponseEntitydownloadImage(@PathVariable String fileName) throws IOException {
        byte[] image = service.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }
}
