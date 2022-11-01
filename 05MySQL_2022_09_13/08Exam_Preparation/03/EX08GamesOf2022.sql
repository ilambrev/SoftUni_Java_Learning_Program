USE `softuni_gdb`;

SELECT g.`name`,
g.`release_date`,
CONCAT(SUBSTRING(g.`description`, 1, 10), "...") AS 'summary',
CASE
	WHEN MONTH(g.`release_date`) BETWEEN 1 AND 3 THEN "Q1"
    WHEN MONTH(g.`release_date`) BETWEEN 4 AND 6 THEN "Q2"
    WHEN MONTH(g.`release_date`) BETWEEN 7 AND 9 THEN "Q3"
    ELSE "Q4"
END AS 'quarter',
t.`name` AS `team_name`
FROM `games` AS g
INNER JOIN `teams` AS t
ON t.`id` = g.`team_id`
WHERE YEAR(g.`release_date`) = 2022 AND RIGHT(g.`name`, 1) = "2" AND MONTH(g.`release_date`) % 2 = 0
ORDER BY `quarter`;