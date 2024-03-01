# Write your MySQL query statement below
SELECT E1.name AS EMPLOYEE 
FROM Employee E1
LEFT JOIN Employee E2
ON E1.MANAGERID = E2.ID
WHERE E1.SALARY>E2.SALARY;