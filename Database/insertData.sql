USE OnlineFoodOrderingSystem;

#Customer table
INSERT INTO customer (first_name, last_name, email, tel_no, user_name, password)
VALUES
    ('John', 'Doe', 'john.doe@email.com', '123-456-7890', 'john_doe', 'pwd123'),
    ('Jane', 'Smith', 'jane.smith@email.com', '987-654-3210', 'jane_smith', 'pwd456'),
    ('Alice', 'Johnson', 'alice.johnson@email.com', '555-123-7890', 'alice_j', 'pwd789'),
    ('Bob', 'Williams', 'bob.williams@email.com', '777-555-1234', 'bob_w', '123pwd'),
    ('Charlie', 'Davis', 'charlie.davis@email.com', '111-222-3333', 'charlie_d', 'securepwd'),
    ('Emma', 'Clark', 'emma.clark@email.com', '444-666-9999', 'emma_c', 'p@ssw0rd'),
    ('Michael', 'Miller', 'michael.miller@email.com', '888-777-5555', 'mike_m', 'millerpass'),
    ('Olivia', 'Taylor', 'olivia.taylor@email.com', '222-444-6666', 'olivia_t', 'taylorpwd'),
    ('Daniel', 'Anderson', 'daniel.anderson@email.com', '666-999-1111', 'daniel_a', 'and123'),
    ('Sophia', 'Brown', 'sophia.brown@email.com', '333-111-2222', 'sophia_b', 'brwnpass');

#Payament table
INSERT INTO payment (customer_id, payment_method, amount, payment_status)
VALUES
    (1, 'Credit Card', 50.00, 'Completed'),
    (2, 'PayPal', 75.50, 'Pending'),
    (3, 'Debit Card', 30.75, 'Failed'),
    (4, 'Bank Transfer', 100.00, 'Completed'),
    (5, 'Cash', 45.25, 'Completed'),
    (6, 'Credit Card', 60.00, 'Pending'),
    (7, 'PayPal', 20.50, 'Failed'),
    (8, 'Debit Card', 90.25, 'Completed'),
    (9, 'Bank Transfer', 70.50, 'Completed'),
    (10, 'Cash', 55.75, 'Pending');
    
#Owner table
INSERT INTO owner (first_name, last_name, email, tel_no, position, password)
VALUES
    ('Mark', 'Johnson', 'mark.johnson@email.com', '123-456-7890', 'CEO', 'pass123'),
    ('Emily', 'Smith', 'emily.smith@email.com', '987-654-3210', 'COO', 'pard456'),
    ('David', 'Anderson', 'david.anderson@email.com', '555-123-7890', 'CTO', 'securep'),
    ('Anna', 'Williams', 'anna.williams@email.com', '777-555-1234', 'CFO', 'pass56'),
    ('Chris', 'Brown', 'chris.brown@email.com', '111-222-3333', 'CMO', 'brownss'),
    ('Sara', 'Davis', 'sara.davis@email.com', '444-666-9999', 'CIO', 'p@sw0d'),
    ('Daniel', 'Taylor', 'daniel.taylor@email.com', '888-777-5555', 'HR Manager', 'taorpass'),
    ('Sophie', 'Miller', 'sophie.miller@email.com', '222-444-6666', 'Operations Manager', 'mill123'),
    ('Alex', 'Clark', 'alex.clark@email.com', '666-999-1111', 'IT Manager', 'clkpass'),
    ('Olivia', 'Moore', 'olivia.moore@email.com', '333-111-2222', 'Marketing Manager', 'moorass');
    
#delivery_person table
INSERT INTO delivery_person (first_name, last_name, email, tel_no, is_active) VALUES
    ('John', 'Doe', 'john.doe@example.com', '123-456-7890', 1),
    ('Jane', 'Smith', 'jane.smith@example.com', '987-654-3210', 1),
    ('Bob', 'Johnson', 'bob.johnson@example.com', '555-123-4567', 1),
    ('Alice', 'Brown', 'alice.brown@example.com', '111-222-3333', 1),
    ('Charlie', 'Davis', 'charlie.davis@example.com', '999-888-7777', 1);

#vehicle table
INSERT INTO vehicle (delivery_person_id, type, registration_number, model, is_active) VALUES
    (1, 'Car', 'ABC123', 'Toyota Camry', 1),
    (2, 'Truck', 'XYZ789', 'Ford F-150', 1),
    (3, 'Motorcycle', 'DEF456', 'Honda CBR', 1),
    (4, 'Scooter', 'GHI789', 'Vespa LX', 1),
    (5, 'Van', 'JKL012', 'Chevrolet Express', 1),
    (1, 'Bicycle', 'MNO345', 'Schwinn Cruiser', 1),
    (2, 'Car', 'PQR678', 'Chevrolet Malibu', 1),
    (3, 'Truck', 'STU901', 'Ram 1500', 1),
    (4, 'Motorcycle', 'VWX234', 'Yamaha R1', 1),
    (5, 'Scooter', 'YZA567', 'Piaggio Vespa', 1);

#admin table
INSERT INTO admin (owner_id, first_name, last_name, email, tel_no, role, user_name, password) VALUES
    (1, 'Admin4', 'LastName4', 'admin4@example.com', '111-222-3333', 'Administrator', 'admin_user4', 'passw4'),
    (2, 'Admin5', 'LastName5', 'admin5@example.com', '999-888-7777', 'Administrator', 'admin_user5', 'pass5'),
    (3, 'Admin6', 'LastName6', 'admin6@example.com', '777-666-5555', 'Administrator', 'admin_user6', 'pass6'),
    (1, 'Admin7', 'LastName7', 'admin7@example.com', '444-555-6666', 'Administrator', 'admin_user7', 'pass7'),
    (2, 'Admin8', 'LastName8', 'admin8@example.com', '333-222-1111', 'Administrator', 'admin_user8', 'pass8'),
    (3, 'Admin9', 'LastName9', 'admin9@example.com', '123-987-4567', 'Administrator', 'admin_user9', 'pass9'),
    (1, 'Admin10', 'LastName10', 'admin10@example.com', '555-777-9999', 'Administrator', 'admin_user10', 'pass10'),
    (2, 'Admin11', 'LastName11', 'admin11@example.com', '111-333-5555', 'Administrator', 'admin_user11', 'pass11'),
    (3, 'Admin12', 'LastName12', 'admin12@example.com', '999-555-1111', 'Administrator', 'admin_user12', 'pass12'),
    (1, 'Admin13', 'LastName13', 'admin13@example.com', '888-444-2222', 'Administrator', 'admin_user13', 'pass13');

#promotion table
INSERT INTO promotion (owner_id, admin_id, discount_percentage, description, promotion_period, terms_and_conditions, is_active) VALUES
    (1, 1, '10%', 'Promotion 1 Description', '2023-01-01', 'Terms and conditions for Promotion 1', 1),
    (2, 2, '20%', 'Promotion 2 Description', '2023-02-01', 'Terms and conditions for Promotion 2', 1),
    (3, 3, '15%', 'Promotion 3 Description', '2023-03-01', 'Terms and conditions for Promotion 3', 1),
    (1, 4, '25%', 'Promotion 4 Description', '2023-04-01', 'Terms and conditions for Promotion 4', 1),
    (2, 5, '12%', 'Promotion 5 Description', '2023-05-01', 'Terms and conditions for Promotion 5', 1),
    (3, 6, '18%', 'Promotion 6 Description', '2023-06-01', 'Terms and conditions for Promotion 6', 1),
    (1, 7, '30%', 'Promotion 7 Description', '2023-07-01', 'Terms and conditions for Promotion 7', 1),
    (2, 8, '22%', 'Promotion 8 Description', '2023-08-01', 'Terms and conditions for Promotion 8', 1),
    (3, 9, '17%', 'Promotion 9 Description', '2023-09-01', 'Terms and conditions for Promotion 9', 1),
    (1, 10, '28%', 'Promotion 10 Description', '2023-10-01', 'Terms and conditions for Promotion 10', 1);
    
#menu table
INSERT INTO menu (menu_name, description, price, category) VALUES
    ('Spaghetti Bolognese', 'Classic Italian dish with meat sauce', 12.99, 'Pasta'),
    ('Chicken Alfredo', 'Creamy Alfredo sauce with grilled chicken', 15.49, 'Pasta'),
    ('Margherita Pizza', 'Tomato, mozzarella, and basil', 10.99, 'Pizza'),
    ('Teriyaki Salmon', 'Grilled salmon with teriyaki glaze', 18.99, 'Seafood'),
    ('Caesar Salad', 'Romaine lettuce, croutons, and Caesar dressing', 8.99, 'Salad'),
    ('Beef Tacos', 'Seasoned ground beef in corn tortillas', 9.99, 'Mexican'),
    ('Chicken Curry', 'Spicy curry with tender chicken', 14.99, 'Indian'),
    ('Pad Thai', 'Stir-fried noodles with shrimp and peanuts', 13.49, 'Thai'),
    ('Sushi Combo', 'Assorted sushi rolls and sashimi', 22.99, 'Japanese'),
    ('Burger Deluxe', 'Juicy beef patty with cheese and toppings', 11.99, 'American');

#orders table
INSERT INTO orders (customer_id, rec_address, send_address, total_amount, order_status) VALUES
    (1, '123 Main St', '456 Second St', 25.99, TRUE),
    (2, '789 Oak St', '101 Pine St', 32.50, FALSE),
    (3, '222 Elm St', '333 Maple St', 18.75, TRUE),
    (1, '444 Pine St', '555 Oak St', 45.00, FALSE),
    (2, '666 Maple St', '777 Elm St', 22.50, TRUE),
    (3, '888 Birch St', '999 Cedar St', 30.25, FALSE),
    (1, '111 Spruce St', '222 Fir St', 15.99, TRUE),
    (2, '333 Willow St', '444 Oak St', 28.75, FALSE),
    (3, '555 Pine St', '666 Elm St', 19.50, TRUE),
    (1, '777 Maple St', '888 Cedar St', 37.80, FALSE);

#inventory table
INSERT INTO inventory (owner_id, quantity, reorder_level, exp_date) VALUES
    (1, 100, 20, '2023-12-31'),
    (2, 75, 15, '2024-03-15'),
    (3, 50, 10, '2023-11-30'),
    (1, 120, 25, '2024-01-10'),
    (2, 90, 18, '2024-02-28'),
    (3, 60, 12, '2023-10-15'),
    (1, 80, 22, '2024-04-20'),
    (2, 110, 30, '2023-09-05'),
    (3, 40, 8, '2024-05-12'),
    (1, 130, 28, '2023-08-01');
    
#admin_menu table
INSERT INTO admin_menu (admin_id, item_id) VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (2, 4),
    (3, 5),
    (3, 6),
    (4, 7),
    (4, 8),
    (5, 9),
    (5, 10);
    
#order_menu
INSERT INTO order_menu (customer_id, item_id) VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (2, 4),
    (3, 5),
    (3, 6),
    (4, 7),
    (4, 8),
    (5, 9),
    (5, 10);

#customer_promotion table
INSERT INTO customer_promotion (customer_id, promotion_id) VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (2, 4),
    (3, 5),
    (3, 6),
    (4, 7),
    (4, 8),
    (5, 9),
    (5, 10);
    
#chef_order table
INSERT INTO chef_order (chef_id,  customer_id) VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (2, 4),
    (3, 5),
    (3, 6),
    (4, 7),
    (4, 8),
    (5, 9),
    (5, 10);
    
    
    
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