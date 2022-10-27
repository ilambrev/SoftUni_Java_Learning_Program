USE `soft_uni`;

SELECT MIN(t1.s) AS 'min_average_salary'
FROM (SELECT AVG(`salary`) AS s
FROM `employees`
GROUP BY `department_id`) AS t1;