USE `softuni_stores_system`;

DELIMITER $$

CREATE FUNCTION udf_top_paid_employee_by_store(store_name VARCHAR(50))

RETURNS TEXT
DETERMINISTIC

BEGIN
	
    DECLARE message TEXT;
    DECLARE store_id INT;
    DECLARE top_paid_employee_id INT;
    
    SET store_id := (SELECT `id` FROM `stores` WHERE `name` = store_name);
    SET top_paid_employee_id := (SELECT e.`id` FROM `employees` AS e WHERE e.`store_id` = store_id
    AND e.`salary` = (SELECT MAX(e1.`salary`) FROM `employees` AS e1 WHERE e1.`store_id` = store_id));
    
    SET message := (SELECT CONCAT(`first_name`, ' ', `middle_name`, '. ', `last_name`, ' ', "works in store for ", TIMESTAMPDIFF(year, `hire_date`, "2020-10-18"), ' years')
    FROM `employees` WHERE `store_id` = store_id AND `id` = top_paid_employee_id);
    
RETURN message;
END$$


SELECT udf_top_paid_employee_by_store('Stronghold') as 'full_info';

SELECT udf_top_paid_employee_by_store('Keylex') as 'full_info';