package com.bonedone.logosshop.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    boolean isExists(String fileName);
    String storeFile(MultipartFile file);
    Resource loadFileByFileName(String fileName);
}
