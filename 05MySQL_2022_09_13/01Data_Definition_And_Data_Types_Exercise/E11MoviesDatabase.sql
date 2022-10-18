CREATE DATABASE `movies`;

USE `movies`;

CREATE TABLE `directors` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `director_name` VARCHAR(255) NOT NULL,
    `notes` TEXT
);

INSERT INTO `directors` (`director_name`)
VALUES
	('Ivan Ivanov'),
    ('Petar Petrov'),
    ('Dimitar Borisov'),
    ('Anton Popov'),
    ('Kiril Georgiev');

CREATE TABLE `genres` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `genre_name` VARCHAR(255) NOT NULL,
    `notes` TEXT
    );

INSERT INTO `genres` (`genre_name`)
VALUES
	('Comedy'),
    ('Action'),
    ('Drama'),
    ('Fantasy'),
    ('Romance');

CREATE TABLE `categories` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `category_name` VARCHAR(255) NOT NULL,
    `notes` TEXT
);

INSERT INTO `categories` (`category_name`)
VALUES
	('Animation'),
    ('Family'),
    ('Science'),
    ('Europian'),
    ('Bulgarian');

CREATE TABLE `movies` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(255) NOT NULL,
    `director_id` INT NOT NULL,
    `copyright_year` INT NOT NULL,
    `length` INT,
    `genre_id` INT NOT NULL,
    `category_id` INT NOT NULL,
    `rating` VARCHAR(255),
    `notes` TEXT
);

INSERT INTO `movies` (`title`, `director_id`, `copyright_year`, `length`, `genre_id`, `category_id`, `rating`)
VALUES
	('Terminator', 3, 1986, 106, 2, 3, 'G'),
    ('Lion King', 5, 1963, 120, 1, 1, 'PG'),
    ('Die Hard', 2, 1999, 145, 5, 4, 'G'),
    ('Indiana Jones', 4, 2015, 123, 3, 2, 'PG'),
    ('The Mummy', 1, 2019, 115, 4, 5, 'G');