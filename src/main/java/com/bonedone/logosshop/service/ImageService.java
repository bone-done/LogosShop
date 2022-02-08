package com.bonedone.logosshop.service;

import com.bonedone.logosshop.domain.ImageDTO;

import java.util.List;

public interface ImageService {
    ImageDTO create(ImageDTO dto);
    ImageDTO update(ImageDTO dto);
    ImageDTO delete(ImageDTO dto);
    String deleteById(String id);
    ImageDTO getEntity(String id);
    List<ImageDTO> getAll();

}
