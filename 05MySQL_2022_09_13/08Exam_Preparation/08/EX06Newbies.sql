USE `ruk_database`;

SELECT `id`,
		CONCAT_WS(' ', `first_name`, `last_name`) AS 'full_name',
        CONCAT("$",`salary`) AS 'salary',
        `started_on`
FROM `employees`
WHERE `salary` >= 100000 AND DATE(`started_on`) >= DATE("2018-01-01")
ORDER BY `salary` DESC, `id` DESC;