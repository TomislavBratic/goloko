CREATE SEQUENCE clients_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE clients (
    id BIGINT PRIMARY KEY DEFAULT nextval('clients_seq'),
    user_id BIGINT NOT NULL,
    business_name VARCHAR(255) NOT NULL,
    subscription_status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    verification_status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    verification_notes TEXT,
    subscription_plan_id BIGINT,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),

    CONSTRAINT uq_clients_user_id UNIQUE (user_id),

    CONSTRAINT fk_clients_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT fk_clients_subscription_plan
        FOREIGN KEY (subscription_plan_id)
        REFERENCES subscription_plans(id)
        ON DELETE SET NULL
        ON UPDATE CASCADE,

    CONSTRAINT chk_clients_subscription_status
        CHECK (subscription_status IN ('PENDING','APPROVED','REJECTED','EXPIRED')),
    CONSTRAINT chk_clients_verification_status
        CHECK (verification_status IN ('PENDING','APPROVED','REJECTED'))
);
-- Indexes
CREATE INDEX idx_clients_subscription_plan_id ON clients (subscription_plan_id);