USE `instd`;

SELECT CONCAT(SUBSTRING(`description`, 1, 30), "...") AS 'summary', `date`
FROM `photos`
WHERE DAY(`date`) = 10
ORDER BY `date` DESC;