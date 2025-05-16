SELECT b.unique_id, a.name
FROM Employees a LEFT JOIN EmployeeUNI b
ON a.id = b.id
ORDER BY a.name