-- Clear existing data
DELETE FROM email;
DELETE FROM phone;
DELETE FROM client;
DELETE FROM user;

-- 1. Users
-- Admin User
INSERT INTO user (user_id, username, password_hash, role, created_at) 
VALUES (
  'a1b2c3d4-5678-90ef-abcd-ef1234567890', 
  'admin',
  '$2a$10$4fBv5J3L6h5W8ZzVQ1xrKuY9Xo6n7dC8gTkU7jDmNlOqPwRs1t2', -- Bcrypt for "123qwei@#"
  'ADMIN',
  CURRENT_TIMESTAMP
);

-- Standard User
INSERT INTO user (user_id, username, password_hash, role, created_at) 
VALUES (
  'b2c3d4e5-6789-01fg-hijk-lm1234567890', 
  'user1',
  '$2a$10$2eRT4QY7U.3v5Hq3Zx9V.O9u7dR4TkLmW1sNlPqJrS8wVbKcM1n2', -- Bcrypt for "123qwei123"
  'STANDARD',
  CURRENT_TIMESTAMP
);

-- 2. Clients (2 for admin, 1 for standard user)
-- Client 1 (Admin)
INSERT INTO client (client_id, name, cpf, cep, street, neighborhood, city, state, user_id, created_at)
VALUES (
  'c1d2e3f4-5678-90ef-abcd-ef1234567890',
  'Maria Silva',
  '12345678901',
  '01311000', -- São Paulo - Av. Paulista
  'Avenida Paulista 1000',
  'Bela Vista',
  'São Paulo',
  'SP',
  'a1b2c3d4-5678-90ef-abcd-ef1234567890', -- Admin's user_id
  CURRENT_TIMESTAMP
);

-- Client 2 (Admin)
INSERT INTO client (client_id, name, cpf, cep, street, neighborhood, city, state, user_id, created_at)
VALUES (
  'd2e3f4g5-6789-01hi-jklm-n12345678901',
  'João Oliveira',
  '98765432109',
  '20040002', -- Rio de Janeiro - Centro
  'Rua do Ouvidor 50',
  'Centro',
  'Rio de Janeiro',
  'RJ',
  'a1b2c3d4-5678-90ef-abcd-ef1234567890', -- Admin's user_id
  CURRENT_TIMESTAMP
);

-- Client 3 (Standard User)
INSERT INTO client (client_id, name, cpf, cep, street, neighborhood, city, state, user_id, created_at)
VALUES (
  'e3f4g5h6-7890-12jk-lmno-p12345678901',
  'Ana Costa',
  '45678912304',
  '30130010', -- Belo Horizonte - Savassi
  'Rua da Bahia 1200',
  'Savassi',
  'Belo Horizonte',
  'MG',
  'b2c3d4e5-6789-01fg-hijk-lm1234567890', -- Standard user's user_id
  CURRENT_TIMESTAMP
);

-- 3. Phones
-- Client 1 Phones
INSERT INTO phone (phone_id, number, type, client_id, created_at) 
VALUES 
  (UUID(), '11987654321', 'CELLPHONE', 'c1d2e3f4-5678-90ef-abcd-ef1234567890', CURRENT_TIMESTAMP),
  (UUID(), '1133334444', 'RESIDENTIAL', 'c1d2e3f4-5678-90ef-abcd-ef1234567890', CURRENT_TIMESTAMP);

-- Client 2 Phones
INSERT INTO phone (phone_id, number, type, client_id, created_at) 
VALUES 
  (UUID(), '21999998888', 'CELLPHONE', 'd2e3f4g5-6789-01hi-jklm-n12345678901', CURRENT_TIMESTAMP),
  (UUID(), '2133335555', 'COMMERCIAL', 'd2e3f4g5-6789-01hi-jklm-n12345678901', CURRENT_TIMESTAMP);

-- Client 3 Phones
INSERT INTO phone (phone_id, number, type, client_id, created_at) 
VALUES 
  (UUID(), '31988887777', 'CELLPHONE', 'e3f4g5h6-7890-12jk-lmno-p12345678901', CURRENT_TIMESTAMP),
  (UUID(), '3133336666', 'RESIDENTIAL', 'e3f4g5h6-7890-12jk-lmno-p12345678901', CURRENT_TIMESTAMP);

-- 4. Emails
-- Client 1 Emails
INSERT INTO email (email_id, address, client_id, created_at) 
VALUES 
  (UUID(), 'maria.silva@example.com', 'c1d2e3f4-5678-90ef-abcd-ef1234567890', CURRENT_TIMESTAMP),
  (UUID(), 'maria.pessoal@gmail.com', 'c1d2e3f4-5678-90ef-abcd-ef1234567890', CURRENT_TIMESTAMP);

-- Client 2 Emails
INSERT INTO email (email_id, address, client_id, created_at) 
VALUES 
  (UUID(), 'joao.oliveira@corp.com', 'd2e3f4g5-6789-01hi-jklm-n12345678901', CURRENT_TIMESTAMP),
  (UUID(), 'joao.pessoal@outlook.com', 'd2e3f4g5-6789-01hi-jklm-n12345678901', CURRENT_TIMESTAMP);

-- Client 3 Emails
INSERT INTO email (email_id, address, client_id, created_at) 
VALUES 
  (UUID(), 'ana.costa@business.com', 'e3f4g5h6-7890-12jk-lmno-p12345678901', CURRENT_TIMESTAMP),
  (UUID(), 'ana.pessoal@yahoo.com.br', 'e3f4g5h6-7890-12jk-lmno-p12345678901', CURRENT_TIMESTAMP);