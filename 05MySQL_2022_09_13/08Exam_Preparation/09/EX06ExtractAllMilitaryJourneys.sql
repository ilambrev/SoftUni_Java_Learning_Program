USE `cjms_db`;

SELECT `id`, `journey_start`, `journey_end`
FROM `journeys`
WHERE `purpose` = "Military"
ORDER BY `journey_start`;