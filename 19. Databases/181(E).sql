# 181. Employees Earning Mroe Than Their Managers (Easy)
# Input: 
# Employee table:
# +----+-------+--------+-----------+
# | id | name  | salary | managerId |
# +----+-------+--------+-----------+
# | 1  | Joe   | 70000  | 3         |
# | 2  | Henry | 80000  | 4         |
# | 3  | Sam   | 60000  | Null      |
# | 4  | Max   | 90000  | Null      |
# +----+-------+--------+-----------+
# Output: 
# +----------+
# | Employee |
# +----------+
# | Joe      |
# +----------+
# Explanation: Joe is the only employee who earns more than his manager.
#
#

SELECT 
    a.Name AS 'Employee'
FROM Employee AS a, Employee AS b
WHERE
    a.ManagerId = b.Id 
    AND a.Salary > b.Salary;
