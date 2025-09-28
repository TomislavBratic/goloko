package com.example.goloko.storage;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
@Profile("local")
public class LocalStorageService implements StorageService{
    private final Path rootLocation;

    public LocalStorageService(){
        this.rootLocation = Path.of(System.getProperty("user.home"),"goloko-uploads");
    }
    @Override
    public String storeFile(MultipartFile file) throws Exception {
        Files.createDirectories(rootLocation);

        String uniqueName = UUID.randomUUID() + "-" +file.getOriginalFilename();
        Path destination = rootLocation.resolve(uniqueName);
        file.transferTo(destination.toFile());
        return "/local-storage/" + uniqueName;
    }
    @Override
    public void deleteFile(String storageUrl) throws Exception {
        // strip leading "/local-storage/"
        String fileName = storageUrl.replaceFirst("^/local-storage/", "");
        Path filePath = rootLocation.resolve(fileName);

        // Delete if exists
        if (Files.exists(filePath)) {
            Files.delete(filePath);
        }
    }
}
