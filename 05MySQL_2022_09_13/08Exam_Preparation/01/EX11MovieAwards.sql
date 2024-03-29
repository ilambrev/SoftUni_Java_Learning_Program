USE `softuni_imdb`;

DELIMITER $$

CREATE PROCEDURE udp_award_movie(movie_title VARCHAR(50))

BEGIN

	UPDATE `actors` AS a1
    
    SET a1.`awards` = a1.`awards` + 1
    WHERE a1.`id` IN (SELECT * FROM (SELECT a.`id`
					FROM `actors` AS a
                    INNER JOIN `movies_actors` ma
                    ON a.`id` = ma.`actor_id`
                    INNER JOIN `movies` AS m
                    ON ma.`movie_id` = m.`id`
                    WHERE m.`title` = movie_title) AS t);
                    
END$$

CALL udp_award_movie('Tea For Two');