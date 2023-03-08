CREATE DATABASE `restaurant_db`;

USE `restaurant_db`;

CREATE TABLE `products` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL UNIQUE,
	`type` VARCHAR(30) NOT NULL,
	`price` DECIMAL(10, 2) NOT NULL
);

CREATE TABLE `clients` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`first_name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
	`birthdate` DATE NOT NULL,
	`card` VARCHAR(50),
	`review` TEXT
);

CREATE TABLE `tables` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`floor` INT NOT NULL,
	`reserved` TINYINT(1),
	`capacity` INT NOT NULL
);

CREATE TABLE `waiters` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`first_name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
	`email` VARCHAR(50) NOT NULL,
	`phone` VARCHAR(50),
	`salary` DECIMAL(10, 2)
);

CREATE TABLE `orders` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`table_id` INT NOT NULL,
	`waiter_id` INT NOT NULL,
	`order_time` TIME NOT NULL,
	`payed_status` TINYINT(1)
);

CREATE TABLE `orders_clients` (
	`order_id` INT,
	`client_id` INT
);

CREATE TABLE `orders_products` (
	`order_id` INT,
	`product_id` INT
);

ALTER TABLE `orders`
ADD CONSTRAINT fk_orders_tables
FOREIGN KEY (`table_id`)
REFERENCES `tables` (`id`),
ADD CONSTRAINT fk_orders_waiters
FOREIGN KEY (`waiter_id`)
REFERENCES `waiters` (`id`);

ALTER TABLE `orders_clients`
ADD CONSTRAINT fk_orders_clients_orders
FOREIGN KEY (`order_id`)
REFERENCES `orders` (`id`),
ADD CONSTRAINT fk_orders_clients_clients
FOREIGN KEY (`client_id`)
REFERENCES `clients` (`id`);

ALTER TABLE `orders_products`
ADD CONSTRAINT fk_orders_products_orders
FOREIGN KEY (`order_id`)
REFERENCES `orders` (`id`),
ADD CONSTRAINT fk_orders_products_products
FOREIGN KEY (`product_id`)
REFERENCES `products` (`id`);