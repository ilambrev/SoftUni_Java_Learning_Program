USE `gringotts`;

SELECT
CASE
	WHEN `age` >= 0 AND `age` <= 10 THEN "[0-10]"
    WHEN `age` >= 11 AND `age` <= 20 THEN "[11-20]"
    WHEN `age` >= 21 AND `age` <= 30 THEN "[21-30]"
    WHEN `age` >= 31 AND `age` <= 40 THEN "[31-40]"
    WHEN `age` >= 41 AND `age` <= 50 THEN "[41-50]"
    WHEN `age` >= 51 AND `age` <= 60 THEN "[51-60]"
    WHEN `age` >= 61 THEN "[61+]"
END AS `age_group`,  COUNT(*) AS `wizard_count`
FROM `wizzard_deposits`
GROUP BY `age_group`
ORDER BY `age_group`;