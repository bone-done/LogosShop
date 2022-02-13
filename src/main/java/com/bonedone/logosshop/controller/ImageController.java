package com.bonedone.logosshop.controller;


import com.bonedone.logosshop.domain.ImageDTO;
import com.bonedone.logosshop.service.FileStorageService;
import com.bonedone.logosshop.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService service;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping
    public ResponseEntity<ImageDTO> getImageById (@PathVariable String id) {
        return ResponseEntity.ok(service.getEntity(id));
    }

    @PostMapping
    public ResponseEntity<ImageDTO> saveImage (@RequestParam Long productId, @RequestParam Boolean isHeadPicture, @RequestParam MultipartFile file) {
        String storedFileName = fileStorageService.storeFile(file);

        ImageDTO dto = new ImageDTO();
        dto.setProductId(productId);
        dto.setFileName(storedFileName);
        dto.setIsHeadPicture(isHeadPicture);
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/file/{fileName}")
    public ResponseEntity<Resource> getImageResourceByFileName (@PathVariable String fileName){
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.IMAGE_PNG)
                .body(fileStorageService.loadFileByFileName(fileName));
    }
}
