CREATE SEQUENCE events_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE events (
    id BIGINT PRIMARY KEY DEFAULT nextval('events_seq'),
    client_location_id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    start_time TIMESTAMP NOT NULL,
    end_time TIMESTAMP NOT NULL,
    location geometry(Point, 4326) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),


    CONSTRAINT fk_events_client_location
        FOREIGN KEY (client_location_id)
        REFERENCES client_locations(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Indexes
CREATE INDEX idx_events_client_location_id ON events (client_location_id);