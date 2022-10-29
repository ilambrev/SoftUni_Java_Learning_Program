USE `soft_uni`;

DELIMITER $$

CREATE PROCEDURE usp_transfer_money(from_account_id INT, to_account_id INT, amount DECIMAL(19, 4))

BEGIN
	
    DECLARE account_balance DECIMAL(19, 4);
    
    SET account_balance := (SELECT `balance` FROM `accounts` WHERE `id` = from_account_id);

	START TRANSACTION;
		IF from_account_id NOT IN (SELECT `id` FROM `accounts`) OR
        to_account_id NOT IN (SELECT `id` FROM `accounts`) OR
        amount <= 0 OR
        account_balance - amount < 0 THEN
    ROLLBACK;
    ELSE
		UPDATE `accounts`
        SET `balance` = `balance` - amount
        WHERE `id` = from_account_id;
        UPDATE `accounts`
        SET `balance` = `balance` + amount
        WHERE `id` = to_account_id;
    END IF;

END$$

CALL usp_transfer_money(1, 2, 10);

SELECT `id`, `account_holder_id`, `balance`
FROM `accounts`
WHERE `id` IN (1, 2);