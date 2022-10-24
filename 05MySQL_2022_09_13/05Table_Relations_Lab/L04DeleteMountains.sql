USE `camp`;

CREATE TABLE `mountains` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL
);

CREATE TABLE `peaks` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `mountain_id` INT,
    CONSTRAINT fk_peak_mountain
    FOREIGN KEY (`mountain_id`)
    REFERENCES `mountains` (id)
    ON DELETE CASCADE
);