USE `online_store`;

DELIMITER $$

CREATE PROCEDURE udp_reduce_price(category_name VARCHAR(50))

BEGIN
	DECLARE category_id INT;
    SET category_id := (SELECT `id` FROM `categories` WHERE `name` = category_name);
    
	UPDATE `products` AS p
    LEFT JOIN `reviews` AS r
    ON p.`review_id` = r.`id`
    SET `price` = `price` * 0.70
    WHERE `category_id` = category_id AND r.`rating` < 4;
END$$

CALL udp_reduce_price("Phones and tablets");