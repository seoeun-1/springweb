DROP DATABASE IF EXISTS mydbpractice;
CREATE DATABASE mydbpractice;
USE mydbpractice;

CREATE TABLE waiting (
    no INT AUTO_INCREMENT PRIMARY key,
    phone VARCHAR(20) NOT NULL,
    customer INT NOT NULL
);

INSERT INTO waiting (phone, customer)
VALUES
('010-0000-0000', 2),
('010-1111-1111', 5),
('010-2222-2222', 4);
select * from waiting;
