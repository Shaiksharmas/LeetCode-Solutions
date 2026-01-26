# Write your MySQL query statement below
SELECT today.id
FROM Weather today
JOIN Weather yesterday
ON today.recordDate = DATE_ADD(yesterday.recordDate, INTERVAL 1 DAY)
WHERE today.temperature > yesterday.temperature;