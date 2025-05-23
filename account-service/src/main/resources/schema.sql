CREATE TABLE IF NOT EXISTS accounts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(30) NOT NULL UNIQUE,
    bank_id BIGINT NOT NULL,
    account_type VARCHAR(20) NOT NULL,
    balance DECIMAL(15, 2) NOT NULL DEFAULT 0.00,
    status VARCHAR(20) NOT NULL
);

INSERT INTO accounts(account_number, bank_id, account_type, balance, status) VALUES ('00000001', 1, 'AHORROS', 100000.00, 'active');
INSERT INTO accounts(account_number, bank_id, account_type, balance, status) VALUES ('00000002', 2, 'CORRIENTE', 250000.00, 'active');
INSERT INTO accounts(account_number, bank_id, account_type, balance, status) VALUES ('00000003', 3, 'AHORROS', 50000.00, 'blocked');
INSERT INTO accounts(account_number, bank_id, account_type, balance, status) VALUES ('00000004', 1, 'CORRIENTE', 75000.00, 'active');
INSERT INTO accounts(account_number, bank_id, account_type, balance, status) VALUES ('00000005', 4, 'AHORROS', 120000.00, 'closed');
INSERT INTO accounts(account_number, bank_id, account_type, balance, status) VALUES ('00000006', 3, 'AHORROS', 50000.00, 'active');
INSERT INTO accounts(account_number, bank_id, account_type, balance, status) VALUES ('00000007', 1, 'CORRIENTE', 75000.00, 'active');
INSERT INTO accounts(account_number, bank_id, account_type, balance, status) VALUES ('00000008', 4, 'AHORROS', 120000.00, 'active');
