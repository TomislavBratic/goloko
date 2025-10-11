package com.example.goloko.admin_setting.web;

import com.example.goloko.admin_setting.application.AdminSettingService;
import com.example.goloko.admin_setting.web.request.CreateAdminSettingRequest;
import com.example.goloko.admin_setting.web.response.CreateAdminSettingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/admin_settings")
public class AdminSettingController {

    private final AdminSettingService service;

    public AdminSettingController(AdminSettingService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreateAdminSettingResponse> create(@RequestBody CreateAdminSettingRequest request){
        CreateAdminSettingResponse saved = service.create(request);

       return ResponseEntity.created(URI.create("/api/admin_settings"))
                .body(saved);
    }
}
