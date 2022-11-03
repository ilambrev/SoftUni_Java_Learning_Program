USE `softuni_stores_system`;

DELIMITER $$

CREATE PROCEDURE udp_update_product_price (address_name VARCHAR (50))

BEGIN

	DECLARE product_id INT;
                    
	UPDATE `products` AS p1
    INNER JOIN (SELECT p.`id` FROM `products` AS p
					INNER JOIN `products_stores` AS ps
                    ON p.`id` = ps.`product_id`
                    INNER JOIN `stores` AS s
                    ON s.`id` = ps.`store_id`
                    INNER JOIN `addresses` AS a
                    ON a.`id` = s.`address_id`
					WHERE a.`name` = address_name) AS t
                    ON t.`id` = p1.`id`
    SET `price` = IF(SUBSTRING(address_name, 1, 1) = "0", `price` + 100, `price` + 200);
    
END$$

CALL udp_update_product_price('07 Armistice Parkway');
SELECT name, price FROM products WHERE id = 15;

CALL udp_update_product_price('1 Cody Pass');
SELECT name, price FROM products WHERE id = 17;