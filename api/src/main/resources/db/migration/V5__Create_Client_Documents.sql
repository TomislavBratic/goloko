CREATE SEQUENCE client_documents_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE client_documents (
    id BIGINT PRIMARY KEY DEFAULT nextval('client_documents_seq'),
    client_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    doc_type VARCHAR(50) NOT NULL DEFAULT 'OTHER',
    storage_url VARCHAR(1024) NOT NULL,
    file_name VARCHAR(255) NOT NULL,
    mime_type VARCHAR(100) NOT NULL,
    uploaded_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    review_status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    reviewer_id BIGINT,
    review_notes TEXT,

    CONSTRAINT fk_client_documents_client
        FOREIGN KEY (client_id)
        REFERENCES clients(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CONSTRAINT fk_client_documents_reviewer
            FOREIGN KEY (reviewer_id)
            REFERENCES users(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE,

    CONSTRAINT chk_client_documents_doc_type
        CHECK (doc_type IN ('COURT_REGISTER','TRADE_REGISTER','ID','OTHER')),
     CONSTRAINT chk_client_documents_review_status
            CHECK (review_status IN ('PENDING','APPROVED','REJECTED'))
);

-- Indexes
CREATE INDEX idx_client_documents_client_id ON client_documents (client_id);