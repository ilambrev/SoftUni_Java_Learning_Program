USE `soft_uni`;

CREATE TABLE `notification_emails` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `recipient` INT,
    `subject` VARCHAR(255),
    `body` VARCHAR(255)
);

DELIMITER $$

CREATE TRIGGER tr_logs_emails

AFTER INSERT
ON `logs`
FOR EACH ROW

BEGIN
	INSERT INTO `notification_emails` (`recipient`, `subject`, `body`)
    VALUES
		(NEW.`account_id`,
        CONCAT(' ', "Balance change for account: ",
        NEW.`account_id`), CONCAT("On", ' ', DATE_FORMAT(NOW(), "%b %d %Y"), ' ', "at", ' ', DATE_FORMAT(NOW(), "%r"), ' ', "your balance was changed from", ' ',
        FORMAT(NEW.`old_sum`, 0), ' ', "to", ' ', FORMAT(FLOOR(NEW.`new_sum`), 0), "."));

END$$

DROP TRIGGER tr_logs_emails;