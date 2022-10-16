USE gamebar;

CREATE TABLE `employees`
(
`id` INT AUTO_INCREMENT,
`first_name` VARCHAR(50) NOT NULL,
`last_name` VARCHAR(50) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE `categories`
(
id INT AUTO_INCREMENT,
`name` VARCHAR(50) Not NULL,
PRIMARY KEY (id)
);

CREATE TABLE `products`
(
`id` INT AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`category_id` INT NOT NULL,
PRIMARY KEY (id)
);