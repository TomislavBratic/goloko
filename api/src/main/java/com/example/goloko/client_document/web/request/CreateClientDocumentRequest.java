package com.example.goloko.client_document.web.request;

import com.example.goloko.client_document.domain.DocType;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public record CreateClientDocumentRequest(
        DocType docType,
        MultipartFile file,
        @Size(max = 5000) String reviewNotes
        ) {}
