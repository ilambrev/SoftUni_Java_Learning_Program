USE `soft_uni`;

SELECT t.`town_id`, t.`name` AS `town_name`, a.`address_text`
FROM `towns` AS t
INNER JOIN `addresses` AS a
ON t.`town_id` = a.`town_id`
WHERE t.`town_id` IN (9, 15, 32)
ORDER BY t.`town_id`, a.`address_id`;