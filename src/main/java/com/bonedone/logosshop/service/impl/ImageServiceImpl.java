package com.bonedone.logosshop.service.impl;

import com.bonedone.logosshop.domain.ImageDTO;
import com.bonedone.logosshop.entity.Image;
import com.bonedone.logosshop.repository.ImageRepository;
import com.bonedone.logosshop.service.ImageService;
import com.bonedone.logosshop.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository repository;

    @Autowired
    private ModelMapperUtil mapper;


    @Override
    public ImageDTO create(ImageDTO dto) {
        Image savedEntity = repository.save(map(dto));
        return map(savedEntity);
    }

    @Override
    public ImageDTO update(ImageDTO dto) {
        Image updatedEntity = repository.save(map(dto));
        return map(updatedEntity);
    }

    @Override
    public ImageDTO delete(ImageDTO dto) {
        repository.delete(mapper.map(dto, Image.class));
        return dto;
    }

    @Override
    public String deleteById(String id) {
        repository.deleteById(id);
        return id;
    }

    @Override
    public ImageDTO getEntity(String id) {
        ImageDTO dto = mapper.map(repository.getById(id), ImageDTO.class);
        return dto;
    }

    @Override
    public List<ImageDTO> getAll() {
        List<ImageDTO> dtoList = mapper.mapAll(repository.findAll(), ImageDTO.class);
        return dtoList;
    }

    private ImageDTO map (Image entity) {
        return mapper.map(entity, ImageDTO.class);
    }

    private Image map (ImageDTO dto) {
        return mapper.map(dto, Image.class);
    }
}
