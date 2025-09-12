
CREATE SEQUENCE subscription_plans_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE subscription_plans (
    id BIGINT PRIMARY KEY DEFAULT nextval('subscription_plans_seq'),
    name VARCHAR(100) NOT NULL,
    max_locations INT NOT NULL,
    price NUMERIC(10,2) NOT NULL,
    duration_months INT DEFAULT 1,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now()
);