package com.example.goloko.client_document.web.response;

import com.example.goloko.client_document.domain.DocType;
import com.example.goloko.client_document.domain.ReviewStatus;

import java.time.Instant;

public record CreateClientDocumentResponse(
        Long id,
        DocType docType,
        String fileName,
        String mimeType,
        Instant uploadedAt,
        ReviewStatus reviewStatus

        //TODO:Send URL for S3
) {
}
