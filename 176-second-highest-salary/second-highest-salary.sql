# Write your MySQL query statement below

-- this is a great way of solving the problem. since we don't know how to get the 2nd 
-- element but we know how to get the 2nd last element (via limit 1, 1 ) we use that and 
-- reverse sort the table.'
SELECT IFNULL((SELECT DISTINCT salary 
                    from employee
                    order by salary desc
                    limit 1,1), null) AS SecondHighestSalary 


-- this is another way to find using salary != max salary; this gives the 2nd max.
-- SELECT MAX(salary) AS SecondHighestSalary
-- from employee
-- where salary <> (select max(salary) from employee);