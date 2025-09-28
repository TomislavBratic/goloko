package com.example.goloko.client_location_document.web.mapper;

import com.example.goloko.client_location_document.domain.ClientLocationDocument;
import com.example.goloko.client_location_document.web.request.CreateClientLocationDocumentRequest;
import com.example.goloko.client_location_document.web.response.CreateClientLocationDocumentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface  ClientLocationDocumentMapper {

    public CreateClientLocationDocumentResponse toResponse(ClientLocationDocument cld);

    public ClientLocationDocument toEntity(CreateClientLocationDocumentRequest cldr);
}
