package com.example.goloko.client_location_document.web;

import com.example.goloko.client_location_document.web.request.CreateClientLocationDocumentRequest;
import com.example.goloko.client_location_document.application.ClientLocationDocumentService;
import com.example.goloko.client_location_document.web.response.CreateClientLocationDocumentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/client_locations/{clientLocationId}/location_documents")
public class ClientLocationDocumentController {
    private final ClientLocationDocumentService service;
    ClientLocationDocumentController(ClientLocationDocumentService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreateClientLocationDocumentResponse> create(@PathVariable Long clientLocationId,
                                                                       @ModelAttribute CreateClientLocationDocumentRequest request) throws Exception{

        CreateClientLocationDocumentResponse saved = service.create(clientLocationId,request);

        return ResponseEntity.created(URI.create("/api/client_locations/" + clientLocationId + "/location_documents" + saved.id()))
                .body(saved);

    }
}
