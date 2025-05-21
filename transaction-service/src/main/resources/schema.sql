CREATE TABLE IF NOT EXISTS transactions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(20) NOT NULL,              -- "DEPOSITO" o "RETIRO"
    account_id BIGINT NOT NULL,
    amount DECIMAL(15, 2) NOT NULL,
    description VARCHAR(255),
    timestamp TIMESTAMP NOT NULL
);
