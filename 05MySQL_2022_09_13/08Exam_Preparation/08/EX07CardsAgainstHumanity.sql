USE `ruk_database`;

SELECT c.`id`, CONCAT(c.`card_number`, ' : ', cl.`full_name`) AS 'card_token'
FROM `cards` AS c
INNER JOIN `bank_accounts` AS ba
ON ba.`id` = c.`bank_account_id`
INNER JOIN `clients` AS cl
ON cl.`id` = ba.`client_id`
ORDER BY c.`id` DESC;