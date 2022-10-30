USE `softuni_imdb`;

DELIMITER $$

CREATE FUNCTION udf_actor_history_movies_count(full_name VARCHAR(50))
RETURNS INT
DETERMINISTIC

BEGIN
	DECLARE number_of_history_movies INT;
	SET number_of_history_movies := (SELECT COUNT(ma.`movie_id`)
    FROM `actors` AS a
    LEFT JOIN `movies_actors` AS ma
    ON a.`id` = ma.`actor_id`
    INNER JOIN `genres_movies` AS gm
    ON ma.`movie_id` = gm.`movie_id`
    WHERE CONCAT_WS(' ', a.`first_name`, a.`last_name`) LIKE full_name AND gm.`genre_id` = 12
    GROUP BY a.`id`
	);

RETURN number_of_history_movies;
END$$

SELECT udf_actor_history_movies_count('Stephan Lundberg')  AS 'history_movies';

SELECT udf_actor_history_movies_count('Jared Di Batista')  AS 'history_movies';