USE `instd`;

DELIMITER $$

CREATE PROCEDURE udp_modify_user(address VARCHAR(30), town VARCHAR(30))

BEGIN
	START TRANSACTION;
    
	IF ((SELECT COUNT(`user_id`) FROM `addresses` WHERE `address` = address AND `town` = town) = 0) THEN
		ROLLBACK;
	ELSE
		UPDATE `users` AS u
        INNER JOIN `addresses` AS a
        ON u.`id` = a.`user_id`
        SET `age` = `age` + 10
        WHERE a.`address` = address AND a.`town` = town;
    END IF;
		
END$$

CALL udp_modify_user ("97 Valley Edge Parkway", "Divinópolis");

SELECT u.`username`, u.`email`, u.`gender`, u.`age`, u.`job_title`
FROM `users` AS u
WHERE u.`username` = 'eblagden21';