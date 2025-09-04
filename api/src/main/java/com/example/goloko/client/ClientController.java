package com.example.goloko.client;

import com.example.goloko.client.application.ClientService;
import com.example.goloko.client.domain.Client;
import com.example.goloko.client.web.request.CreateClientRequest;
import com.example.goloko.client.web.response.ClientResponse;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    ClientService service;

    public ClientController(ClientService service){
        this.service = service;
    }
    @PostMapping()
    public ResponseEntity<ClientResponse> createClient(@RequestBody CreateClientRequest request){
        Client saved = service.create(request);
        return ResponseEntity.created(URI.create("api/clients/" + saved.getId()))
                .body(ClientResponse.from(saved));
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> get(@PathVariable Long id){
        return ResponseEntity.of(service.get(id));
    }
}
