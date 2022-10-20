USE `book_library`;

SELECT `title` FROM `books`
WHERE `title` LIKE "%Harry Potter%"
ORDER BY `id`;