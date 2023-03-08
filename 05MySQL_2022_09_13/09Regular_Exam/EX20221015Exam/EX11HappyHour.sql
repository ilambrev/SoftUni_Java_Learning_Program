USE `restaurant_db`;

DELIMITER $$

CREATE PROCEDURE udp_happy_hour(type VARCHAR(50))

BEGIN
	UPDATE `products`
    SET `price` = `price` * 0.8
    WHERE `type` = type AND `price` >= 10.00;
END$$

CALL udp_happy_hour ('Cognac');