/* Write your PL/SQL query statement below */
SELECT today.id 
FROM Weather yesterday
CROSS JOIN Weather today
WHERE today.recorddate - yesterday.recorddate = 1
    AND today.temperature > yesterday.temperature 
;