USE `diablo`;

SELECT `name` AS `game`,
CASE
	WHEN HOUR(`start`) >= 0 AND HOUR(`start`) < 12 THEN "Morning"
    WHEN HOUR(`start`) >= 12 AND HOUR(`start`) < 18 THEN "Afternoon"
    WHEN HOUR(`start`) >= 18 AND HOUR(`start`) < 24 THEN "Evening"
END AS `Part of the Day`, 
CASE
	WHEN `duration` <= 3 THEN "Extra Short"
    WHEN `duration` > 3 AND `duration` <= 6 THEN "Short"
    WHEN `duration` > 6 AND `duration` <= 10 THEN "Long"
    WHEN `duration` > 10 OR `duration` IS NULL THEN "Extra Long"
END AS `Duration`
FROM `games`;