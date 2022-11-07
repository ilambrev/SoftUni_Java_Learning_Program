USE `cjms_db`;

DELIMITER $$

CREATE FUNCTION udf_count_colonists_by_destination_planet (planet_name VARCHAR (30))

RETURNS INT
DETERMINISTIC

BEGIN

	DECLARE colonists_num INT;
    SET colonists_num := (SELECT COUNT(tc.`colonist_id`)
						FROM `travel_cards` AS tc
                        INNER JOIN `journeys` AS j
                        ON j.`id` = tc.`journey_id`
                        INNER JOIN `spaceports` AS s
                        ON s.`id` = j.`destination_spaceport_id`
                        RIGHT JOIN `planets` AS p
                        ON p.`id` = s.`planet_id`
						WHERE p.`name` = planet_name
                        GROUP BY p.`name`);
RETURN colonists_num;
END$$

SELECT p.name, udf_count_colonists_by_destination_planet("Otroyphus") AS count
FROM planets AS p
WHERE p.name = "Otroyphus";