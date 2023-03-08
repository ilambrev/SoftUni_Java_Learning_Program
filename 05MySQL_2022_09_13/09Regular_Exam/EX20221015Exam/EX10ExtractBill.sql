USE `restaurant_db`;

DELIMITER $$

CREATE FUNCTION udf_client_bill(full_name VARCHAR(50))

RETURNS DECIMAL(19, 2)
DETERMINISTIC

BEGIN
	DECLARE bill DECIMAL(19, 2);
    
    SET bill := (SELECT SUM(p.`price`)
    FROM `clients` AS c
    LEFT JOIN `orders_clients` AS oc
    ON c.`id` = oc.`client_id`
    INNER JOIN `orders_products` AS op
    ON oc.`order_id` = op.`order_id`
    INNER JOIN `products` AS p
    ON p.`id` = op.`product_id`
    WHERE CONCAT(c.`first_name`, ' ', c.`last_name`) = full_name);

RETURN bill;

END$$

SELECT c.first_name,c.last_name, udf_client_bill('Silvio Blyth') as 'bill' FROM clients c
WHERE c.first_name = 'Silvio' AND c.last_name= 'Blyth';