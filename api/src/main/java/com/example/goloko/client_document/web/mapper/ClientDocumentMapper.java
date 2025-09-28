package com.example.goloko.client_document.web.mapper;

import com.example.goloko.client_document.domain.ClientDocument;
import com.example.goloko.client_document.web.request.CreateClientDocumentRequest;
import com.example.goloko.client_document.web.response.CreateClientDocumentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientDocumentMapper {

    CreateClientDocumentResponse toResponse(ClientDocument doc);

    @Mapping(target = "client", ignore = true)
    ClientDocument toEntity(CreateClientDocumentRequest cd);

}
