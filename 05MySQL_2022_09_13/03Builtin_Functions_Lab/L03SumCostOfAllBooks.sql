USE `book_library`;

SELECT ROUND(SUM(`cost`), 2)
FROM `books`;