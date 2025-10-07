CREATE SEQUENCE client_location_documents_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE client_location_documents (
    id BIGINT PRIMARY KEY DEFAULT nextval('client_location_documents_seq'),
    client_location_id BIGINT NOT NULL,
    doc_type VARCHAR(50) NOT NULL DEFAULT 'OTHER',
    storage_url VARCHAR(1024) NOT NULL,
    file_name VARCHAR(255) NOT NULL,
    mime_type VARCHAR(100) NOT NULL,
    uploaded_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    review_status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    reviewer_id BIGINT,
    review_notes TEXT,

    CONSTRAINT fk_client_location_documents_client_location
        FOREIGN KEY (client_location_id)
        REFERENCES client_locations(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CONSTRAINT fk_client_location_documents_reviewer
            FOREIGN KEY (reviewer_id)
            REFERENCES users(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    CONSTRAINT chk_client_location_documents_doc_type
        CHECK (doc_type IN ('COURT_REGISTER','TRADE_REGISTER','ID','OTHER')),
     CONSTRAINT chk_client_location_documents_review_status
            CHECK (review_status IN ('PENDING','APPROVED','REJECTED'))
);

-- Indexes
CREATE INDEX idx_client_location_documents_client_location_id ON client_location_documents (client_location_id);