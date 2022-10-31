USE `online_store`;

DELIMITER $$

CREATE FUNCTION udf_customer_products_count(name VARCHAR(30))
RETURNS INT
DETERMINISTIC

BEGIN
	DECLARE number_of_orders INT;
    DECLARE customer_id INT;
    
    SET customer_id := (SELECT `id` FROM `customers` WHERE `first_name` = name);
    
    SET number_of_orders := (
		SELECT COUNT(`product_id`)
		FROM `orders_products` AS op
        INNER JOIN `orders` AS o
        ON op.`order_id` = o.`id`
        WHERE o.`customer_id` = customer_id
        );

RETURN number_of_orders;
END$$

SELECT c.first_name, c.last_name, udf_customer_products_count('Shirley') as `total_products` FROM customers c
WHERE c.first_name = 'Shirley';