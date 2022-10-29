USE `soft_uni`;

DELIMITER $$

CREATE FUNCTION ufn_calculate_future_value(initial_sum DECIMAL(10, 4), yearly_interest_rate DOUBLE, number_of_years INT)
RETURNS DECIMAL(10, 4)
DETERMINISTIC

BEGIN
    
    RETURN initial_sum * (POWER((1 + yearly_interest_rate), number_of_years));

END$$

CREATE PROCEDURE usp_calculate_future_value_for_account(account_id INT, interest_rate DECIMAL(10, 4))

BEGIN

	SELECT a.`id`,
    ah.`first_name`,
    ah.`last_name`,
    a.`balance` AS 'current_balance',
    ufn_calculate_future_value(a.`balance`, interest_rate, 5) AS 'balance_in_5_years'
    FROM `accounts` AS a
    INNER JOIN `account_holders` AS ah
    ON a.`account_holder_id` = ah.`id`
    WHERE a.`id` = account_id;

END$$

CALL usp_calculate_future_value_for_account(1, 0.1);