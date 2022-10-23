USE `gringotts`;

SELECT `deposit_group`
FROM `wizzard_deposits` GROUP BY `deposit_group`
ORDER BY AVG(`magic_wand_size`)
LIMIT 1;