# Write your MySQL query statement below
SELECT score, DENSE_RANK() OVER(ORDER BY Score DESC) 'rank'
FROM scores s
order by Score desc