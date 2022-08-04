WITH unique_sells AS (
    SELECT DISTINCT sell_date, product
    FROM Activities
) SELECT
    sell_date AS sell_date,
    COUNT(sell_date) AS num_sold,
    LISTAGG(product, ',') WITHIN GROUP (ORDER BY sell_date, product) AS products
FROM unique_sells
GROUP BY sell_date
ORDER BY sell_date ASC;