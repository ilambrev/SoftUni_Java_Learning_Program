USE gamebar;

ALTER TABLE `employees`
ADD `middle_name` VARCHAR(50) NOT NULL AFTER `first_name`;