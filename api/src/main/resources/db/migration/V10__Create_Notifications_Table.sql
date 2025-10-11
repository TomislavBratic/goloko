CREATE SEQUENCE notifications_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE notifications (
    id BIGINT PRIMARY KEY DEFAULT nextval('notifications_seq'),
    user_id BIGINT NOT NULL,
    message TEXT,
    is_read BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),

       CONSTRAINT fk_notifications_user
            FOREIGN KEY (user_id)
            REFERENCES users(id)
            ON DELETE CASCADE
            ON UPDATE CASCADE
);

-- Indexes
CREATE INDEX idx_notifications_user_id ON notifications (user_id);