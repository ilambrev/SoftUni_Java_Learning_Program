USE `book_library`;

SELECT `title` FROM books
WHERE SUBSTRING(`title`, 1, 3) = "The"
ORDER BY `id`;