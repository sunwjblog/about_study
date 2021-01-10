/*
有一个courses 表 ，有: student (学生) 和 class (课程)。

请列出所有超过或等于5名学生的课。

例如，表：

+---------+------------+
| student | class      |
+---------+------------+
| A       | Math       |
| B       | English    |
| C       | Math       |
| D       | Biology    |
| E       | Math       |
| F       | Computer   |
| G       | Math       |
| H       | Math       |
| I       | Math       |
+---------+------------+
应该输出:

+---------+
| class   |
+---------+
| Math    |
+---------+
*/

#方式1：
select a.class from (select distinct student,class from courses) a group by class having count(class)>=5;

#方式2:
#方法一：使用 GROUP BY 子句和子查询【通过】
#step1
SELECT
    class, COUNT(DISTINCT student)
FROM
    courses
GROUP BY class
;
#step2:
SELECT
    class
FROM
    (SELECT
        class, COUNT(DISTINCT student) AS num
    FROM
        courses
    GROUP BY class) AS temp_table
WHERE
    num >= 5
;

#方法二：使用 GROUP BY 和 HAVING 条件【通过】
SELECT
    class
FROM
    courses
GROUP BY class
HAVING COUNT(DISTINCT student) >= 5
;


