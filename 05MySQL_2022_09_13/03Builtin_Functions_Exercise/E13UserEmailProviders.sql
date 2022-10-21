USE `diablo`;

SELECT `user_name`, SUBSTRING(`email`, LOCATE('@', `email`, 1) + 1) AS `email provider`
FROM `users`
ORDER BY `email provider`, `user_name`;