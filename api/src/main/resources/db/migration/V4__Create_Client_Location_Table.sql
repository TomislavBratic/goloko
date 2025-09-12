CREATE SEQUENCE client_locations_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE client_locations (
    id BIGINT PRIMARY KEY DEFAULT nextval('client_locations_seq'),
    client_id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,

    -- PostGIS geometry type for a WGS84 point
    coordinates geometry(Point, 4326) NOT NULL,

    formatted_addr VARCHAR(500),
    place_id VARCHAR(255),
    address_text TEXT,
    is_verified BOOLEAN NOT NULL DEFAULT FALSE,
    verification_notes TEXT,
    subscription_plan_id BIGINT,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),

    CONSTRAINT fk_client_locations_client
        FOREIGN KEY (client_id)
        REFERENCES clients(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    CONSTRAINT fk_client_locations_subscription_plan
        FOREIGN KEY (subscription_plan_id)
        REFERENCES subscription_plans(id)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

-- Indexes
CREATE INDEX idx_client_locations_client_id ON client_locations (client_id);
CREATE INDEX idx_client_locations_coordinates ON client_locations USING GIST (coordinates);