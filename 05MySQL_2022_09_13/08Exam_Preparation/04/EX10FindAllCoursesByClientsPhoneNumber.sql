USE `softuni_stc`;

DELIMITER $$

CREATE FUNCTION udf_courses_by_client (phone_num VARCHAR (20))
RETURNS INT
DETERMINISTIC

BEGIN

	DECLARE number_of_courses INT;
    SET number_of_courses := (SELECT COUNT(c.`id`) FROM `courses` AS c INNER JOIN `clients` AS cl ON cl.`id` = c.`client_id` WHERE cl.`phone_number` = phone_num);
    
RETURN number_of_courses;    
END$$

SELECT udf_courses_by_client ('(803) 6386812') as `count`;

SELECT udf_courses_by_client ('(831) 1391236') as `count`;

SELECT udf_courses_by_client ('(704) 2502909') as `count`;