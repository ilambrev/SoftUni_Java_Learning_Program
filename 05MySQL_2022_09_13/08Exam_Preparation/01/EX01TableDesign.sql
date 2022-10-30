CREATE DATABASE `softuni_imdb`;

USE `softuni_imdb`;

CREATE TABLE `countries` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(30) UNIQUE NOT NULL,
	`continent` VARCHAR(30) NOT NULL,
	`currency` VARCHAR(5) NOT NULL
);

CREATE TABLE `genres` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name`VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE `actors` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`first_name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
	`birthdate` DATE NOT NULL,
	`height` INT,
	`awards` INT,
	`country_id` INT NOT NULL
);

ALTER TABLE `actors`
ADD CONSTRAINT fk_actors_countries
FOREIGN KEY (`country_id`)
REFERENCES `countries` (`id`);

CREATE TABLE `movies_additional_info` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`rating` DECIMAL(10, 2) NOT NULL,
	`runtime` INT NOT NULL,
	`picture_url` VARCHAR(80) NOT NULL,
	`budget` DECIMAL(10, 2),
	`release_date` DATE NOT NULL,
	`has_subtitles` BOOLEAN,
	`description` TEXT
);

CREATE TABLE `movies` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`title` VARCHAR(70) UNIQUE NOT NULL,
	`country_id` INT NOT NULL,
	`movie_info_id` INT UNIQUE NOT NULL
);

ALTER TABLE `movies`
ADD CONSTRAINT fk_movies_countries
FOREIGN KEY (`country_id`)
REFERENCES `countries` (`id`),
ADD CONSTRAINT fk_movies_movies_additional_info
FOREIGN KEY (`movie_info_id`)
REFERENCES `movies` (`id`);

CREATE TABLE `movies_actors` (
	`movie_id` INT,
	`actor_id`INT
);

ALTER TABLE `movies_actors`
ADD CONSTRAINT fk_movies
FOREIGN KEY (`movie_id`)
REFERENCES `movies` (`id`),
ADD CONSTRAINT fk_actors
FOREIGN KEY (`actor_id`)
REFERENCES `actors` (`id`);

CREATE TABLE `genres_movies` (
	`genre_id` INT,
	`movie_id` INT
);

ALTER TABLE `genres_movies`
ADD CONSTRAINT fk_genres
FOREIGN KEY (`genre_id`)
REFERENCES `genres` (`id`),
ADD CONSTRAINT fk_movies_from_genre_movies
FOREIGN KEY (`movie_id`)
REFERENCES `movies` (`id`);