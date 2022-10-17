USE `minions`;

CREATE TABLE `users` (
    `id` INT PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(30) NOT NULL,
    `password` VARCHAR(26) NOT NULL,
    `profile_picture` MEDIUMBLOB,
    `last_login_time` TIME,
    `is_deleted` BOOLEAN DEFAULT FALSE
);

INSERT INTO `users` (`username`, `password`, `last_login_time`)
VALUES
	('i_ivanov', 'secret', NOW()),
    ('p_petrov', 'pass123', NOW()),
    ('d_todorova', 'mydogname', NOW()),
    ('t_todorov', 'strongpass', NOW()),
    ('s_borisova', 'crocodile', NOW());