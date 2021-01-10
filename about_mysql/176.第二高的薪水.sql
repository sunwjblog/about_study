/*编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。

+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
*/

#Sql1:
#存在如果不存在第二高的薪水，那么查询应返回 null
select distinct Salary as SecondHighestSalary from Employee order by Salary desc limit 1 OFFSET 1; 

#Sql2:
#利用子句查询，解决存在如果不存在第二高的薪水，那么查询应返回 null
SELECT
    (SELECT DISTINCT
            Salary
        FROM
            Employee
        ORDER BY Salary DESC
        LIMIT 1 OFFSET 1) AS SecondHighestSalary
;

#Sql3:
#解决 “NULL” 问题的另一种方法是使用 “IFNULL” 函数

SELECT
    IFNULL(
      (SELECT DISTINCT Salary
       FROM Employee
       ORDER BY Salary DESC
        LIMIT 1 OFFSET 1),
    NULL) AS SecondHighestSalary