USE `camp`;

DROP TABLE `mountains`;

DROP TABLE `peaks`;

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

INSERT INTO `mountains` (`name`)
VALUES
	("Rila"),
    ("Pirin");

INSERT INTO `peaks` (`name`, `mountain_id`)
VALUES
	("Musala", 1),
    ("Vihren", 2);

DELETE FROM `mountains`
WHERE `id` = 1;