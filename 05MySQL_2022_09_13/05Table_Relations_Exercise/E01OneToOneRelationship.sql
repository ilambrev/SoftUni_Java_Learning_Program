CREATE DATABASE `table_relations`;

USE `table_relations`;

CREATE TABLE `passports` (
	`passport_id` INT PRIMARY KEY AUTO_INCREMENT,
    `passport_number` VARCHAR(255) UNIQUE
);

INSERT INTO `passports` (`passport_id`, `passport_number`)
VALUES
	(101, "N34FG21B"),
    (102, "K65LO4R7"),
    (103, "ZE657QP2");

CREATE TABLE `people` (
	`person_id` INT PRIMARY KEY AUTO_INCREMENT,
    `first_name` VARCHAR(255),
    `salary` DECIMAL(10, 2),
    `passport_id` INT UNIQUE,
    CONSTRAINT fk_people_passports
	FOREIGN KEY (`passport_id`)
	REFERENCES `passports` (`passport_id`)
);

INSERT INTO `people` (`first_name`, `salary`, `passport_id`)
VALUES
	("Roberto", 43300.00, 102),
    ("Tom", 56100.00, 103),
    ("Yana", 60200.00, 101);