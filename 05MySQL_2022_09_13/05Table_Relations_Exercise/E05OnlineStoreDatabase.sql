CREATE DATABASE `my_shop`;

USE `my_shop`;

CREATE TABLE `item_types` (
	`item_type_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50)
);

CREATE TABLE `items` (
	`item_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50),
    `item_type_id` INT
);

CREATE TABLE `order_items` (
	`order_id` INT,
    `item_id` INT,
    PRIMARY KEY (`order_id`, `item_id`)
);

CREATE TABLE `orders` (
	`order_id` INT PRIMARY KEY AUTO_INCREMENT,
    `customer_id` INT
);

CREATE TABLE `customers` (
	`customer_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50),
    `birthday` DATE,
    `city_id` INT
);

CREATE TABLE `cities` (
	`city_id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) UNIQUE
);

ALTER TABLE `items`
ADD CONSTRAINT fk_items_item_types
FOREIGN KEY (`item_type_id`)
REFERENCES `item_types` (`item_type_id`);

ALTER TABLE `order_items`
ADD CONSTRAINT fk_order_items_items
FOREIGN KEY(`item_id`)
REFERENCES `items` (`item_id`),
ADD CONSTRAINT fk_order_items_orders
FOREIGN KEY(`order_id`)
REFERENCES `orders` (`order_id`);

ALTER TABLE `orders`
ADD CONSTRAINT fk_orders_customers
FOREIGN KEY (`customer_id`)
REFERENCES `customers` (`customer_id`);

ALTER TABLE `customers`
ADD CONSTRAINT fk_customers_cities
FOREIGN KEY (`city_id`)
REFERENCES `cities` (`city_id`);