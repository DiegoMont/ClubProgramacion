SELECT DISTINCT p1.email AS email
FROM Person as p1 CROSS JOIN Person as p2
WHERE
    p1.email = p2.email AND
    p1.id <> p2.id;