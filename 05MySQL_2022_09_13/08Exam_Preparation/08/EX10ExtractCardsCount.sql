USE `ruk_database`;

DELIMITER $$

CREATE FUNCTION udf_client_cards_count(name VARCHAR(30))

RETURNS INT
DETERMINISTIC

BEGIN

	DECLARE cards_count INT;
    SET cards_count := (SELECT COUNT(c.`id`)
						FROM `clients` AS cl
                        LEFT JOIN `bank_accounts` AS ba
                        ON cl.`id` = ba.`client_id`
                        INNER JOIN `cards` AS c
                        ON ba.`id` = c.`bank_account_id`
                        WHERE cl.`full_name` = name
                        GROUP BY cl.`id`);

RETURN cards_count;
END$$

SELECT c.`full_name`, udf_client_cards_count("Baxy David") as 'cards' FROM `clients` AS c
WHERE c.`full_name` = "Baxy David";