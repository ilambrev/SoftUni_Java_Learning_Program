USE `softuni_imdb`;

UPDATE `movies_additional_info`
SET `runtime` = `runtime` - 10
WHERE `id` BETWEEN 15 AND 25;