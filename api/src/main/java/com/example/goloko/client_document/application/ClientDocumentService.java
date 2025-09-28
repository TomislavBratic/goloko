package com.example.goloko.client_document.application;

import com.example.goloko.client.domain.Client;
import com.example.goloko.client.domain.ClientRepository;
import com.example.goloko.client_document.domain.ClientDocument;
import com.example.goloko.client_document.domain.ClientDocumentRepository;
import com.example.goloko.client_document.web.mapper.ClientDocumentMapper;
import com.example.goloko.client_document.web.request.CreateClientDocumentRequest;
import com.example.goloko.client_document.web.response.CreateClientDocumentResponse;
import com.example.goloko.exceptions.NotFoundException;
import com.example.goloko.storage.StorageService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ClientDocumentService {
    private final ClientDocumentRepository repository;
    private final StorageService storage;
    private final ClientRepository clientRepository;
    private final ClientDocumentMapper clientDocumentMapper;

    public ClientDocumentService(ClientDocumentRepository repository, StorageService storage,
                                 ClientRepository clientRepository, ClientDocumentMapper clientDocumentMapper) {
        this.repository = repository;
        this.storage = storage;
        this.clientRepository = clientRepository;
        this.clientDocumentMapper = clientDocumentMapper;
    }

    @Transactional
    public CreateClientDocumentResponse create(Long clientId, CreateClientDocumentRequest request) throws Exception {

        Client client = clientRepository.findById(clientId).orElseThrow(() -> new NotFoundException("Client not found!"));

        String storageUrl = null;
        try {
            storageUrl = storage.storeFile(request.file());

            ClientDocument doc = new ClientDocument();
            doc.setClient(client);
            doc.setDocType(request.docType());
            doc.setFileName(request.file().getOriginalFilename());
            doc.setMimeType(request.file().getContentType());
            doc.setStorageUrl(storageUrl);
            doc.setReviewNotes(request.reviewNotes());

            repository.save(doc);
            return clientDocumentMapper.toResponse(doc);

        } catch (Exception e) {
            if (storageUrl != null) {
                storage.deleteFile(storageUrl);
            }
            throw e;
        }
    }
}
