package com.example.goloko.client_location_document.web.request;

import com.example.goloko.client_location_document.domain.DocType;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public record CreateClientLocationDocumentRequest(
        DocType docType,
        MultipartFile file,
        @Size(max = 5000) String reviewNotes
) {
}
