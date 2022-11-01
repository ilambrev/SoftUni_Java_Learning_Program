USE `softuni_gdb`;

DELIMITER $$

CREATE PROCEDURE udp_update_budget(min_game_rating FLOAT)

BEGIN
	UPDATE `games`
    SET `budget` = `budget` + 100000,
    `release_date` = DATE_ADD(`release_date`, INTERVAL 1 YEAR)
    WHERE `rating` > min_game_rating AND `release_date` IS NOT NULL AND `id` NOT IN (SELECT * FROM (SELECT `game_id` FROM `games_categories`) AS t);
END$$

CALL udp_update_budget (8);