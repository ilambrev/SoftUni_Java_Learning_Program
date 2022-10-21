USE `soft_uni`;

SELECT `town_id`, `name`
FROM `towns`
WHERE `name` NOT LIKE("R%") AND `name` NOT LIKE("B%") AND `name` NOT LIKE("D%")
ORDER BY `name`;