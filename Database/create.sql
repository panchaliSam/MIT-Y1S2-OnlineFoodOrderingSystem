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

CREATE TABLE payment (
	payment_id INT NOT NULL AUTO_INCREMENT,
	payment_method VARCHAR(100) NOT NULL,
	amount DECIMAL(10, 2) NOT NULL,
	payment_status VARCHAR(100) NOT NULL,
	payment_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	customer_id INT NOT NULL,
	is_active TINYINT(1) NOT NULL DEFAULT 1,
	PRIMARY KEY (payment_id)
);

CREATE TABLE owner (
	owner_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    tel_no VARCHAR(20) NOT NULL,
    position VARCHAR(50) NOT NULL,
    password CHAR(10) NOT NULL,
    PRIMARY KEY (owner_id)
);

CREATE TABLE promotion (
	promotion_id INT NOT NULL AUTO_INCREMENT,
    item_id INT NOT NULL,
    discount_percentage VARCHAR(3),
    description VARCHAR(1000),
    promotion_period DATE,
    terms_and_conditions VARCHAR(1000),
    PRIMARY KEY (promotion_id)
);

CREATE TABLE vehicle(
   vehicle_id INT NOT NULL AUTO_INCREMENT,
   type VARCHAR(100) NOT NULL,
   registration_number VARCHAR(100) NOT NULL,
   model VARCHAR(100) NOT NULL,
   is_active TINYINT(1) NOT NULL DEFAULT 1,
   PRIMARY KEY (vehicle_id)
);

CREATE TABLE delivery_person (
	delivery_person_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    tel_no VARCHAR(20) NOT NULL,
    is_active TINYINT(1) NOT NULL DEFAULT 1,
    PRIMARY KEY (delivery_person_id)
);

CREATE TABLE chef (
	chef_id INT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    specialiation VARCHAR(100) NOT NULL,
    shift VARCHAR(100) NOT NULL,
    is_active TINYINT(1) NOT NULL DEFAULT 1,
    PRIMARY KEY(chef_id)
);

CREATE TABLE admin (
	admin_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    tel_no VARCHAR(20) NOT NULL,
    role VARCHAR(100) NOT NULL,
    user_name VARCHAR(20) NOT NULL,
    password CHAR(10) NOT NULL,
    is_active TINYINT(1) NOT NULL DEFAULT 1,
    registration_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (admin_id)
);

CREATE TABLE menu (
    item_id INT NOT NULL,
    menu_name VARCHAR(100) NOT NULL,
    description VARCHAR(100) NOT NULL,
    price INT NOT NULL,
    category VARCHAR(100) NOT NULL,
    is_active TINYINT(1) NOT NULL DEFAULT 1,
    PRIMARY KEY(item_id)
);

CREATE TABLE orders (
    order_id INT NOT NULL AUTO_INCREMENT,
    order_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    rec_address VARCHAR(255) NOT NULL,
    send_address VARCHAR(255) NOT NULL,
    total_amount DECIMAL(10, 2) NOT NULL,
    order_status BOOLEAN NOT NULL,
    is_active TINYINT(1) NOT NULL DEFAULT 1,
    PRIMARY KEY (order_id)
);

CREATE TABLE inventory (
    inventory_id INT NOT NULL AUTO_INCREMENT,
    quantity INTEGER NOT NULL,
    reorder_level INTEGER NOT NULL,
    purchase_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    exp_date DATE NOT NULL,
    is_active TINYINT(1) NOT NULL DEFAULT 1,
    PRIMARY KEY (inventory_id)
);

SELECT * FROM orders;
SELECT * FROM inventory;
SELECT * FROM admin;
SELECT * FROM menu;
SELECT * FROM customer;
SELECT * FROM payment;
SELECT * FROM owner;
SELECT * FROM promotion;
SELECT * FROM vehicle;
SELECT * FROM delivery_person;
SELECT * FROM chef;
SELECT * FROM admin;