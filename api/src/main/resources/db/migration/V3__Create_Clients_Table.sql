CREATE TABLE clients (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    business_name VARCHAR(255) NOT NULL,
    subscription_status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    verification_status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    verification_notes TEXT NULL,
    subscription_plan_id BIGINT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uq_client_user_id UNIQUE (user_id),

    CONSTRAINT fk_clients_user
        FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE RESTRICT ON UPDATE CASCADE,

    CONSTRAINT fk_clients_subscription_plan
    FOREIGN KEY (subscription_plan_id) REFERENCES subscription_plans(id)
    ON DELETE SET NULL ON UPDATE CASCADE,

    CONSTRAINT chk_subscription_status CHECK (subscription_status IN('PENDING','APPROVED','REJECTED','EXPIRED')),
    CONSTRAINT chk_verification_status CHECK (verification_status IN('PENDING','APPROVED','REJECTED'))

);

CREATE INDEX idx_fk_clients_subscription_plan_id ON clients (subscription_plan_id);