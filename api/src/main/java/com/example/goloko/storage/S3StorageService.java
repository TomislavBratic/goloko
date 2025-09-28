package com.example.goloko.storage;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Profile({"dev","prod"})
public class S3StorageService implements StorageService{
    @Override
    public String storeFile(MultipartFile file) throws Exception {
        // TODO:upload to AWS S3 with AWS SDK v2 or v3
        // Put file to bucket -> get public URL
        return "https://s3.amazonaws.com/goloko-client-documents-dev/" + file.getOriginalFilename();
    }

    @Override
    public void deleteFile(String url) throws Exception {

    }
}
