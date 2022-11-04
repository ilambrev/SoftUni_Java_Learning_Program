USE `instd`;

SELECT p.`id` AS 'photo_id',
		(SELECT COUNT(l1.`photo_id`)
        FROM `photos` AS p1
		LEFT JOIN `likes` AS l1
		ON p1.`id` = l1.`photo_id`
        WHERE p1.`id` = p.`id`
        GROUP BY p1.`id`) AS 'likes_count',
COUNT(c.`photo_id`) AS 'comments_count'
FROM `photos` AS p
LEFT JOIN `comments` AS c
ON p.`id` = c.`photo_id`
GROUP BY p.`id`
ORDER BY `likes_count` DESC, `comments_count` DESC, p.`id`;