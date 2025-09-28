package com.example.goloko.client_location.web;


import com.example.goloko.client_location.application.ClientLocationService;
import com.example.goloko.client_location.web.request.CreateClientLocationRequest;
import com.example.goloko.client_location.web.response.CreateClientLocationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/clients/{clientId}/locations")
public class ClientLocationController {
    private ClientLocationService service;

    public ClientLocationController(ClientLocationService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreateClientLocationResponse> create(@PathVariable Long clientId, @RequestBody CreateClientLocationRequest request){
        CreateClientLocationResponse saved = service.create(clientId,request);

        return ResponseEntity.created(URI.create("/api/clients/" + clientId + "/locations/" + saved.id()))
                .body(saved);
    }
}
