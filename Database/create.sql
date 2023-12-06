CREATE DATABASE OnlineFoodOrderingSystem;

USE OnlineFoodOrderingSystem;

CREATE TABLE customer (
    customer_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    tel_no VARCHAR(20) NOT NULL,
    user_name VARCHAR(20) NOT NULL,
    password CHAR(10) NOT NULL,
    is_active TINYINT(1) NOT NULL DEFAULT 1,
    registration_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (customer_id)
);
