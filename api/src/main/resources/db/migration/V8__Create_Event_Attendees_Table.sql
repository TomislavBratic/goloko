CREATE SEQUENCE event_attendees_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE event_attendees (
    id BIGINT PRIMARY KEY DEFAULT nextval('event_attendees_seq'),
    event_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    status VARCHAR(20)NOT NULL DEFAULT 'INTERESTED',
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),


    CONSTRAINT fk_event_attendees_event
        FOREIGN KEY (event_id)
        REFERENCES events(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CONSTRAINT fk_event_attendees_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CONSTRAINT chk_event_attendees_status CHECK (status IN ('ATTENDING','INTERESTED','DECLINED'))
);

-- Indexes
CREATE INDEX idx_event_attendees_event_id ON event_attendees (event_id);
CREATE INDEX idx_event_attendees_user_id ON event_attendees (user_id);