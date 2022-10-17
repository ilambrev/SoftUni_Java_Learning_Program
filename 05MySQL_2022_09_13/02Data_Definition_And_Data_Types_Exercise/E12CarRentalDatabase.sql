CREATE DATABASE `car_rental`;

USE `car_rental`;

CREATE TABLE `categories` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `category` VARCHAR(255) NOT NULL,
    `daily_rate` DOUBLE(10, 2) NOT NULL,
    `weekly_rate` DOUBLE(10, 2) NOT NULL,
    `monthly_rate` DOUBLE(10, 2) NOT NULL,
    `weekend_rate` DOUBLE(10, 2) NOT NULL
);

INSERT INTO `categories` (`category`, `daily_rate`, `weekly_rate`, `monthly_rate`, `weekend_rate`)
VALUES
	('Mini', 64.00, 336.00, 1290.00, 132.00),
    ('Compact', 70.00, 371.00, 1440.00, 145.00),
    ('Intermediate', 100.00, 476.00, 1800.00, 190.00);

CREATE TABLE `cars` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `plate_number` VARCHAR(255) NOT NULL, 
    `make` VARCHAR(255) NOT NULL,
    `model` VARCHAR(255) NOT NULL,
    `car_year` INT NOT NULL,
    `category_id` INT NOT NULL,
    `doors` INT NOT NULL,
    `picture` BLOB,
    `car_condition` VARCHAR(255),
    `available` BOOLEAN DEFAULT TRUE
);

INSERT INTO `cars` (`plate_number`, `make`, `model`, `car_year`, `category_id`, `doors`)
VALUES
	('C2134AB', 'Skoda', 'Octavia', 2017, 3, 5),
    ('CA3254BB', 'Seat', 'MII', 2015, 1, 5),
    ('CB6754CM', 'Volkswagen', 'Golf', 2016, 2, 3);

CREATE TABLE `employees` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(255) NOT NULL,
    `last_name` VARCHAR(255) NOT NULL,
    `title` VARCHAR(255) NOT NULL,
    `notes` TEXT
);

INSERT INTO `employees` (`first_name`, `last_name`, `title`)
VALUES
	('Ivan', 'Ivanov', 'Sales manager'),
    ('Petar', 'Petrov', 'Director'),
    ('Georgi', 'Georgiev', 'Marketing specialist');

CREATE TABLE `customers` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `driver_licence_number` INT NOT NULL,
    `full_name` VARCHAR(255) NOT NULL,
    `address` VARCHAR(255) NOT NULL,
    `city` VARCHAR(255) NOT NULL,
    `zip_code` INT NOT NULL,
    `notes` TEXT
);

INSERT INTO `customers` (`driver_licence_number`, `full_name`, `address`, `city`, `zip_code`)
VALUES
	(900800700, 'Boris Borisov', '123 Bulgaria Blvd', 'Sofia', 1408),
    (500300200, 'Manol Manolov', '23 Bacho Kiro Str', 'Plovdiv', 4004),
    (100500900, 'Emil Emilov', '21 Alabin Str', 'Burgas', 8019);

CREATE TABLE `rental_orders` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `employee_id` INT NOT NULL,
    `customer_id` INT NOT NULL,
    `car_id` INT NOT NULL,
    `car_condition` VARCHAR(255) NOT NULL,
    `tank_level` VARCHAR(255) NOT NULL,
    `kilometrage_start` INT NOT NULL,
    `kilometrage_end` INT NOT NULL,
    `total_kilometrage` INT NOT NULL,
    `start_date` DATE NOT NULL,
    `end_date` DATE NOT NULL,
    `total_days` INT NOT NULL,
    `rate_applied` DOUBLE(10 , 2 ) NOT NULL,
    `tax_rate` DOUBLE(10 , 2 ) NOT NULL,
    `order_status` ENUM('pending', 'paid', 'canceled') NOT NULL,
    `notes` TEXT
);

INSERT INTO `rental_orders` (`employee_id`, `customer_id`, `car_id`, `car_condition`, `tank_level`, `kilometrage_start`, `kilometrage_end`,
`total_kilometrage`, `start_date`, `end_date`, `total_days`, `rate_applied`, `tax_rate`, `order_status`)
VALUES
	(1, 1, 1, 'Exelent', 'Full', 52305, 53305, 1000, '2022-09-01', '2022-09-07', 7, 476.00, 476.00, 'paid'),
    (2, 2, 2, 'Good', 'Full', 42100, 42600, 500, '2022-07-01', '2022-07-01', 1, 64.00, 64.00, 'canceled'),
    (3, 3, 3, 'Exelent', 'Full', 10200, 10300, 100, '2022-02-11', '2022-02-15', 5, 350.00, 70.00, 'pending');