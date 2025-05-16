WITH highest_salary AS (
    SELECT MAX(salary) AS salary
    FROM Employee
)
SELECT MAX(salary) AS "SecondHighestSalary"
FROM Employee
WHERE salary < (SELECT salary FROM highest_salary);