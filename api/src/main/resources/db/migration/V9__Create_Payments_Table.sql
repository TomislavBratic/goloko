CREATE SEQUENCE payments_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE payments (
    id BIGINT PRIMARY KEY DEFAULT nextval('payments_seq'),
    user_id BIGINT NOT NULL,
    client_id BIGINT NOT NULL,
    subscription_plan_id BIGINT NOT NULL,
    amount NUMERIC(10,2) NOT NULL,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    payment_date TIMESTAMPTZ NOT NULL DEFAULT now(),

       CONSTRAINT fk_payments_user
            FOREIGN KEY (user_id)
            REFERENCES users(id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

       CONSTRAINT fk_payments_client
            FOREIGN KEY (client_id)
            REFERENCES clients(id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE,

        CONSTRAINT fk_payments_subscription_plan
           FOREIGN KEY (subscription_plan_id)
           REFERENCES subscription_plans(id)
           ON DELETE RESTRICT
           ON UPDATE CASCADE,

    CONSTRAINT chk_payments_status CHECK (status IN ('COMPLETED','PENDING','FAILED'))
);

-- Indexes
CREATE INDEX idx_payments_user_id ON payments (user_id);
CREATE INDEX idx_payments_client_id ON payments (client_id);