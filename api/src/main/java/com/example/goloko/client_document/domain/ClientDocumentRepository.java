package com.example.goloko.client_document.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDocumentRepository extends JpaRepository<ClientDocument,Long> {
}
