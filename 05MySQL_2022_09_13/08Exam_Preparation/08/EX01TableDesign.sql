CREATE DATABASE `ruk_database`;

USE `ruk_database`;

CREATE TABLE `branches` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(30) NOT NULL UNIQUE
);

CREATE TABLE `employees` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`first_name` VARCHAR(20) NOT NULL,
	`last_name` VARCHAR(20) NOT NULL,
	`salary` DECIMAL(10, 2) NOT NULL,
	`started_on` DATE NOT NULL,
	`branch_id` INT NOT NULL
);

CREATE TABLE `clients` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`full_name` VARCHAR(50) NOT NULL,
	`age` INT NOT NULL
);

CREATE TABLE `employees_clients` (
	`employee_id` INT,
	`client_id` INT
);

CREATE TABLE `bank_accounts` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`account_number` VARCHAR(10) NOT NULL,
	`balance` DECIMAL(10, 2) NOT NULL,
	`client_id` INT NOT NULL UNIQUE
);

CREATE TABLE `cards` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`card_number` VARCHAR(19) NOT NULL,
	`card_status` VARCHAR(7) NOT NULL,
	`bank_account_id` INT NOT NULL
);

ALTER TABLE `employees`
ADD CONSTRAINT fk_employees_branches
FOREIGN KEY (`branch_id`)
REFERENCES `branches` (`id`);

ALTER TABLE `employees_clients`
ADD CONSTRAINT fk_employees_clients_employees
FOREIGN KEY (`employee_id`)
REFERENCES `employees` (`id`),
ADD CONSTRAINT fk_employees_clients_clients
FOREIGN KEY (`client_id`)
REFERENCES `clients` (`id`);

ALTER TABLE `bank_accounts`
ADD CONSTRAINT fk_bank_accounts_clients
FOREIGN KEY (`client_id`)
REFERENCES `clients` (`id`);

ALTER TABLE `cards`
ADD CONSTRAINT fk_cards_bank_accounts
FOREIGN KEY (`bank_account_id`)
REFERENCES `bank_accounts` (`id`);