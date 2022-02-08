package com.bonedone.logosshop.controller;


import com.bonedone.logosshop.domain.ImageDTO;
import com.bonedone.logosshop.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageService service;

    @GetMapping
    public ResponseEntity<ImageDTO> getImageById (@PathVariable String id) {
        return ResponseEntity.ok(service.getEntity(id));
    }

    @PostMapping
    public ResponseEntity<ImageDTO> saveImage (@RequestParam Long productId, @RequestParam String fileName, @RequestParam Boolean isHeadPicture) {
        ImageDTO dto = new ImageDTO();
        dto.setProductId(productId);
        dto.setFileName(fileName);
        dto.setIsHeadPicture(isHeadPicture);
        return ResponseEntity.ok(service.create(dto));
    }
}
