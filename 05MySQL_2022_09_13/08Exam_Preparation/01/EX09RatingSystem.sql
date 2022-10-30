USE `softuni_imdb`;

SELECT m.`title`,
	IF(mai.`rating` <= 4, "poor", (IF(mai.`rating` > 4 AND mai.`rating` <= 7, "good", "excellent"))) AS `rating`,
    IF(mai.`has_subtitles` = 1, "english", "-")  AS 'subtitles',
    mai.`budget`
FROM `movies` AS m
INNER JOIN `movies_additional_info` AS mai
ON mai.`id` = m.`movie_info_id`

ORDER BY mai.`budget` DESC;