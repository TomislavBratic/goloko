package com.example.goloko.client_location_document.web.response;

import com.example.goloko.client_location_document.domain.DocType;
import com.example.goloko.client_document.domain.ReviewStatus;

import java.time.Instant;

public record CreateClientLocationDocumentResponse(
        Long id,
        DocType docType,
        String fileName,
        String mimeType,
        Instant uploadedAt,
        ReviewStatus reviewStatus
) {
}
