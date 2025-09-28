package com.example.goloko.client_location_document.application;

import com.example.goloko.client_location.domain.ClientLocation;
import com.example.goloko.client_location.domain.ClientLocationRepository;
import com.example.goloko.client_location_document.domain.ClientLocationDocument;
import com.example.goloko.client_location_document.domain.ClientLocationDocumentRepository;
import com.example.goloko.client_location_document.web.mapper.ClientLocationDocumentMapper;
import com.example.goloko.client_location_document.web.request.CreateClientLocationDocumentRequest;
import com.example.goloko.client_location_document.web.response.CreateClientLocationDocumentResponse;
import com.example.goloko.exceptions.NotFoundException;
import com.example.goloko.storage.StorageService;
import org.springframework.stereotype.Service;

@Service
public class ClientLocationDocumentService {

    private final ClientLocationDocumentRepository repository;
    private final ClientLocationRepository clientLocationRepository;
    private final StorageService storageService;
    private final ClientLocationDocumentMapper mapper;

    public ClientLocationDocumentService(ClientLocationDocumentRepository repository, ClientLocationRepository clientLocationRepository,
                                         StorageService storageService, ClientLocationDocumentMapper mapper) {
        this.repository = repository;
        this.clientLocationRepository = clientLocationRepository;
        this.storageService = storageService;
        this.mapper = mapper;
    }

    public CreateClientLocationDocumentResponse create(Long clientLocationId, CreateClientLocationDocumentRequest request) throws Exception {

        ClientLocation clientLocation = clientLocationRepository.findById(clientLocationId).orElseThrow(() -> new NotFoundException("client location not found"));


        String storageUrl = null;
        try {
            storageUrl = storageService.storeFile(request.file());

            ClientLocationDocument doc = new ClientLocationDocument();
            doc.setClientLocation(clientLocation);
            doc.setFileName(request.file().getOriginalFilename());
            doc.setMimeType(request.file().getContentType());
            doc.setDocType(request.docType());
            doc.setStorageUrl(storageUrl);
            doc.setReviewNotes(request.reviewNotes());

            repository.save(doc);
            return mapper.toResponse(doc);

        } catch (Exception e) {
            if (storageUrl != null)
                storageService.deleteFile(storageUrl);
            throw e;
        }
    }
}
