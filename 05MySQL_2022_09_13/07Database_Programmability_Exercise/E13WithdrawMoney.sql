USE `soft_uni`;

DELIMITER $$

CREATE PROCEDURE usp_withdraw_money(account_id INT, money_amount DECIMAL(19, 4))

BEGIN
	DECLARE account_balance DECIMAL(19, 4);
    
    SET account_balance := (SELECT `balance` FROM `accounts` WHERE `id` = account_id);
	START TRANSACTION;
		IF money_amount <= 0 OR account_balance - money_amount < 0 THEN
    ROLLBACK;
    ELSE
		UPDATE `accounts`
        SET `balance` = `balance` - money_amount
        WHERE `id` = account_id;
    END IF;
    
END$$

CALL usp_withdraw_money(1, 10);

SELECT `id`, `account_holder_id`, `balance`
FROM `accounts`
WHERE `id` = 1;