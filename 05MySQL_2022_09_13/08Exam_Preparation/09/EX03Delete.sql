USE `cjms_db`;

DELETE FROM `colonists` AS c
WHERE c.`id` NOT IN (SELECT * FROM (SELECT tc.`colonist_id` FROM `travel_cards` AS tc) AS t);