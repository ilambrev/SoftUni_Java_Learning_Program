USE `minions`;

ALTER TABLE `users`
MODIFY COLUMN `last_login_time` DATETIME DEFAULT NOW();