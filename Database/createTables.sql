CREATE DATABASE OnlineFoodOrderingSystem;

USE OnlineFoodOrderingSystem;

CREATE TABLE customer (
    customer_id 		INT 			NOT NULL AUTO_INCREMENT,
    first_name			VARCHAR(100) 	NOT NULL,
    last_name 			VARCHAR(100) 	NOT NULL,
    email 				VARCHAR(100) 	NOT NULL,
    tel_no 				VARCHAR(20) 	NOT NULL,
    user_name 			VARCHAR(20) 	NOT NULL,
    password 			CHAR(10) 		NOT NULL,
    is_active 			TINYINT(1) 		NOT NULL DEFAULT 1,
    registration_date 	DATETIME 		NOT NULL DEFAULT CURRENT_TIMESTAMP,
    
    PRIMARY KEY (customer_id)
);

CREATE TABLE payment (
	payment_id 			INT 			NOT NULL AUTO_INCREMENT,
    customer_id 		INT 			NOT NULL,
	payment_method 		VARCHAR(100) 	NOT NULL,
	amount 				DECIMAL(10, 2) 	NOT NULL,
	payment_status 		VARCHAR(100) 	NOT NULL,
	payment_date 		DATETIME 		NOT NULL DEFAULT CURRENT_TIMESTAMP,	
	is_active 			TINYINT(1)	 	NOT NULL DEFAULT 1,
    
	PRIMARY KEY (payment_id),
    
    CONSTRAINT fk_payment FOREIGN KEY(customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE owner (
	owner_id 			INT 			NOT NULL AUTO_INCREMENT,
    first_name 			VARCHAR(100) 	NOT NULL,
    last_name 			VARCHAR(100) 	NOT NULL,
    email 				VARCHAR(100) 	NOT NULL,
    tel_no 				VARCHAR(20) 	NOT NULL,
    position 			VARCHAR(50)		NOT NULL,
    password 			CHAR(10) 		NOT NULL,
    is_active 			TINYINT(1)	 	NOT NULL DEFAULT 1,
    
    PRIMARY KEY (owner_id)
);

CREATE TABLE promotion (
	promotion_id 			INT 			NOT NULL AUTO_INCREMENT,
    owner_id 				INT 			NOT NULL,
    admin_id 				INT 			NOT NULL,
    discount_percentage 	VARCHAR(3)		NOT NULL,
    description	 			VARCHAR(1000)	NOT NULL,
    promotion_period 		VARCHAR(100)	NOT NULL,
    terms_and_conditions 	VARCHAR(1000)   NOT NULL,
    is_active 				TINYINT(1)	 	NOT NULL DEFAULT 1,
    
    PRIMARY KEY (promotion_id),
    
    CONSTRAINT fk1_promotion FOREIGN KEY(owner_id) REFERENCES owner(owner_id),
    CONSTRAINT fk2_promotion  FOREIGN KEY(admin_id) REFERENCES admin(admin_id)
);

CREATE TABLE vehicle(
   vehicle_id 			INT 			NOT NULL AUTO_INCREMENT,
   delivery_person_id 	INT 			NOT NULL,
   type 				VARCHAR(100) 	NOT NULL,
   registration_number 	VARCHAR(100) 	NOT NULL,
   model 				VARCHAR(100) 	NOT NULL,
   is_active 			TINYINT(1) 		NOT NULL DEFAULT 1,
   
   PRIMARY KEY (vehicle_id),
   
   CONSTRAINT fk_vehicle FOREIGN KEY(delivery_person_id ) REFERENCES delivery_person(delivery_person_id )
);

CREATE TABLE delivery_person (
	delivery_person_id 	INT 			NOT NULL AUTO_INCREMENT,
    first_name 			VARCHAR(100) 	NOT NULL,
    last_name 			VARCHAR(100) 	NOT NULL,
    email 				VARCHAR(100) 	NOT NULL,
    tel_no 				VARCHAR(20) 	NOT NULL,
    is_active 			TINYINT(1) 		NOT NULL DEFAULT 1,
    PRIMARY KEY (delivery_person_id)
);

CREATE TABLE chef (
	chef_id 			INT 			NOT NULL AUTO_INCREMENT,
	first_name 			VARCHAR(100) 	NOT NULL,
    last_name 			VARCHAR(100)	NOT NULL,
	email 				VARCHAR(100) 	NOT NULL,
    tel_no 				VARCHAR(20) 	NOT NULL,
    specialiation 		VARCHAR(100) 	NOT NULL,
    shift 				VARCHAR(100) 	NOT NULL,
    is_active 			TINYINT(1) 		NOT NULL DEFAULT 1,
    
    PRIMARY KEY(chef_id)
);

CREATE TABLE admin (
	admin_id 			INT 			NOT NULL AUTO_INCREMENT,
    owner_id 			INT 			NOT NULL,
    first_name 			VARCHAR(100) 	NOT NULL,
    last_name 			VARCHAR(100) 	NOT NULL,
    email 				VARCHAR(100) 	NOT NULL,
    tel_no				VARCHAR(20) 	NOT NULL,
    role 				VARCHAR(100)	NOT NULL,
    user_name 			VARCHAR(20) 	NOT NULL,
    password 			CHAR(10) 		NOT NULL,    
    registration_date 	DATETIME 		NOT NULL DEFAULT CURRENT_TIMESTAMP,
    is_active 			TINYINT(1) 		NOT NULL DEFAULT 1,
    
    PRIMARY KEY (admin_id),
    
    CONSTRAINT fk_admin FOREIGN KEY(owner_id) REFERENCES owner(owner_id)
);

CREATE TABLE menu (
    item_id 		INT 			NOT NULL AUTO_INCREMENT,
    menu_name 		VARCHAR(100) 	NOT NULL,
    description 	VARCHAR(100) 	NOT NULL,
    price 			DECIMAL(10, 2)	NOT NULL,
    category 		VARCHAR(100) 	NOT NULL,
    is_active 		TINYINT(1) 		NOT NULL DEFAULT 1,
    
    PRIMARY KEY(item_id)
);

CREATE TABLE orders (
    order_id 			INT 			NOT NULL AUTO_INCREMENT,
    customer_id 		INT 			NOT NULL,
    order_date 			DATETIME 		NOT NULL DEFAULT CURRENT_TIMESTAMP,
    rec_address 		VARCHAR(255) 	NOT NULL,
    send_address 		VARCHAR(255) 	NOT NULL,
    total_amount 		DECIMAL(10, 2) 	NOT NULL,
    order_status 		BOOLEAN 		NOT NULL,
    is_active 			TINYINT(1) 		NOT NULL DEFAULT 1,
    
    PRIMARY KEY (order_id, customer_id ),
    
    CONSTRAINT fk_orders FOREIGN KEY(customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE inventory (
    inventory_id 		INT 		NOT NULL AUTO_INCREMENT,
    owner_id 			INT 		NOT NULL,
    quantity 			INT 		NOT NULL,
    reorder_level 		INT 		NOT NULL,
    purchase_date 		DATETIME 		NOT NULL DEFAULT CURRENT_TIMESTAMP,
    exp_date 			DATE 		NOT NULL,
    is_active 			TINYINT(1) 	NOT NULL DEFAULT 1,
    
    PRIMARY KEY (inventory_id),
    
	CONSTRAINT fk_inventory FOREIGN KEY(owner_id) REFERENCES owner(owner_id)
);

CREATE TABLE admin_menu(
	admin_id 	INT 	NOT NULL,
    item_id 	INT 	NOT NULL,
    
    PRIMARY KEY(admin_id, item_id),
    
	CONSTRAINT fk1_admin_menu FOREIGN KEY(admin_id) REFERENCES admin(admin_id),
    CONSTRAINT fk2_admin_menu  FOREIGN KEY(item_id) REFERENCES menu(item_id)
);

CREATE TABLE order_menu(
	customer_id 	INT 	NOT NULL,
    item_id 		INT 	NOT NULL,
    
    PRIMARY KEY(customer_id, item_id),
    
	CONSTRAINT fk1_order_menu FOREIGN KEY(customer_id) REFERENCES orders(customer_id),
    CONSTRAINT fk2_order_menu  FOREIGN KEY(item_id) REFERENCES menu(item_id)
);

CREATE TABLE customer_promotion(
	customer_id 	INT 	NOT NULL,
    promotion_id 	INT 	NOT NULL,
    
    PRIMARY KEY(customer_id,  promotion_id),
    
	CONSTRAINT fk1_customer_promotion FOREIGN KEY(customer_id) REFERENCES customer(customer_id),
    CONSTRAINT fk2_customer_promotion FOREIGN KEY(promotion_id) REFERENCES promotion(promotion_id)    
);

CREATE TABLE chef_order(
	chef_id 		INT 	NOT NULL,
    customer_id 	INT 	NOT NULL,
    
    PRIMARY KEY(chef_id, customer_id),
    
	CONSTRAINT fk1_chef_order FOREIGN KEY(chef_id) REFERENCES chef(chef_id),
    CONSTRAINT fk2_chef_order FOREIGN KEY( customer_id) REFERENCES  orders(customer_id)  
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
SELECT * FROM admin_menu;
SELECT * FROM order_menu;
SELECT * FROM customer_promotion;
SELECT * FROM chef_order;
