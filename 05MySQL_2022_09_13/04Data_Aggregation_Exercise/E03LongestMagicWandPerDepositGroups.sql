USE `gringotts`;

SELECT `deposit_group`,
MAX(`magic_wand_size`) AS `longest_magic_wand`
FROM `wizzard_deposits` GROUP BY `deposit_group`
ORDER BY `longest_magic_wand`, `deposit_group`;