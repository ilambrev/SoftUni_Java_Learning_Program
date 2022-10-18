USE `minions`;

CREATE TABLE `people` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(200) NOT NULL,
    `picture` MEDIUMBLOB,
    `height` DOUBLE(10 , 2 ),
    `weight` DOUBLE(10 , 2 ),
    `gender` ENUM('m', 'f') NOT NULL,
    `birthdate` DATE NOT NULL,
    `biography` LONGTEXT
);

INSERT INTO `people` (`name`, `height`, `weight`, `gender`, `birthdate`)
VALUES
	('Ivan Ivanov', 1.85, 82, 'm', '1982-12-07'),
    ('Petar Petrov', 1.90, 102, 'm', '1989-04-15'),
    ('Dobrinka Todorova', 1.62, 47, 'f', '1974-09-12'),
    ('Todor Todorov', 1.74, 72, 'm', '1965-03-20'),
    ('Svetla Borisova', 1.55, 45, 'f', '1999-01-01');