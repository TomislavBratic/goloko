package com.example.goloko.client_document.domain;

import com.example.goloko.client.domain.Client;
import com.example.goloko.client_location.domain.ClientLocation;
import com.example.goloko.user.domain.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.event.spi.RefreshEventListener;

import java.time.Instant;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client_documents")
public class ClientDocument {
    @Id
    @SequenceGenerator(name = "client_documents_seq", sequenceName = "client_documents_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "client_documents_seq")
    @EqualsAndHashCode.Include
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id",nullable = false,
            foreignKey = @ForeignKey(name = "fk_client_documents_client"))
    private Client client;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 50)
    private DocType docType;
    @Column(nullable = false, length = 1024)
    private String storageUrl;
    @Column(nullable = false, length = 255)
    private String fileName;
    @Column(nullable = false, length = 100)
    private String mimeType;
    private Instant uploadedAt = Instant.now();
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 20)
    private ReviewStatus reviewStatus = ReviewStatus.PENDING;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewer_id",
            foreignKey = @ForeignKey(name = "fk_client_documents_user"))
    private User reviewer;
    @Lob
    @Column(columnDefinition = "TEXT")
    public String reviewNotes;

    @PrePersist
    void prePersist() {
        if (docType == null) docType = DocType.OTHER;
    }
}
