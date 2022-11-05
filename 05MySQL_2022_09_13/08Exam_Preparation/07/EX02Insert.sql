USE `fsd`;

INSERT INTO `coaches` (`first_name`, `last_name`, `salary`, `coach_level`)
(SELECT p.`first_name`, p.`last_name`, p.`salary` * 2, CHAR_LENGTH(p.`first_name`) AS `coach_level`
FROM `players` AS p
WHERE `age` >= 45);