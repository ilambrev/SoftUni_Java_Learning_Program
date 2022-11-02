USE `softuni_stc`;

DELETE FROM `clients` AS c
WHERE CHAR_LENGTH(c.`full_name`) > 3 AND c.`id` NOT IN (SELECT * FROM (SELECT DISTINCT(c1.`client_id`) FROM `courses` AS c1) t1);