USE `ruk_database`;

INSERT INTO `cards` (`card_number`, `card_status`, `bank_account_id`)
SELECT REVERSE(`full_name`), "Active", `id`
FROM `clients`
WHERE `id` BETWEEN 191 AND 200;