USE `ruk_database`;

DELIMITER $$

CREATE PROCEDURE udp_clientinfo(full_name VARCHAR(50))

BEGIN
	SELECT cl.`full_name`, cl.`age`, `account_number`, CONCAT("$", `balance`) AS 'balance'
    FROM `clients` AS cl
    LEFT JOIN `bank_accounts` AS ba
    ON cl.`id` = ba.`client_id`
    WHERE cl.`full_name` = full_name;
END;

CALL udp_clientinfo("Hunter Wesgate");