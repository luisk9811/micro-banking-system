CREATE TABLE IF NOT EXISTS banks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(200) NOT NULL
);

INSERT INTO banks(name, description) VALUES ('Bancolombia','Descripción Banco 1');
INSERT INTO banks(name, description) VALUES ('Davivienda','Descripción Banco 2');
INSERT INTO banks(name, description) VALUES ('BBVA','Descripción Banco 3');
INSERT INTO banks(name, description) VALUES ('Fallabela','Descripción Banco 4');
INSERT INTO banks(name, description) VALUES ('Itaú','Descripción Banco 5');