package com.example.goloko.client_document.web;

import com.example.goloko.client_document.application.ClientDocumentService;
import com.example.goloko.client_document.web.request.CreateClientDocumentRequest;
import com.example.goloko.client_document.web.response.CreateClientDocumentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/clients/{clientId}/documents")
public class ClientDocumentController {

    private final ClientDocumentService service;

    public ClientDocumentController(ClientDocumentService service){
        this.service = service;
    }
      @PostMapping
      public ResponseEntity<CreateClientDocumentResponse> create(@PathVariable Long clientId,
              @ModelAttribute CreateClientDocumentRequest request) throws Exception {

          CreateClientDocumentResponse saved = service.create(clientId, request);
          return ResponseEntity.created(URI.create("/api/clients/" + clientId + "/documents/" + saved.id()))
                  .body(saved);
      }
}
