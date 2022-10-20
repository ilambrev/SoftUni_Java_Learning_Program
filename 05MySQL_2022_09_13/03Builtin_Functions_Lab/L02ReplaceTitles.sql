USE `book_library`;

SELECT REPLACE(`title`, "The", "***") AS `title`
FROM `books`
WHERE SUBSTRING(`title`, 1, 3) = "The";