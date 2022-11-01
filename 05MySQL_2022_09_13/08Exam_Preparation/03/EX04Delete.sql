USE `softuni_gdb`;

DELETE FROM `games`
WHERE `id` NOT IN (SELECT * FROM (SELECT DISTINCT(`game_id`) FROM `games_categories`) AS t)
AND `release_date` IS NULL;