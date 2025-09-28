package com.example.goloko.storage;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    String storeFile(MultipartFile file) throws Exception;
    void deleteFile(String url) throws Exception;
}

