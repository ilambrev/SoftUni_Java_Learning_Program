USE `softuni_gdb`;

DELIMITER $$

CREATE FUNCTION udf_game_info_by_name (game_name VARCHAR (20))
RETURNS TEXT
DETERMINISTIC

BEGIN
	DECLARE sentence TEXT;
    DECLARE team_name VARCHAR(40);
    DECLARE address VARCHAR(50);
    
    SET team_name := (SELECT t.`name` FROM `teams` AS t INNER JOIN `games` AS g ON t.`id` = g.`team_id` WHERE g.`name` = game_name);
    SET address := (SELECT a.`name` FROM `addresses` AS a 
					INNER JOIN `offices` AS o ON a.`id` = o.`address_id`
                    INNER JOIN `teams` AS t ON o.`id` = t.`office_id`
                    WHERE t.`name` = team_name); 
    
    SET sentence := CONCAT_WS(' ', "The", game_name, "is developed by a", team_name, "in an office with an address", address);

RETURN sentence;
END$$

SELECT udf_game_info_by_name('Bitwolf') AS info;

SELECT udf_game_info_by_name('Fix San') AS info;

SELECT udf_game_info_by_name('Job') AS info;