-- Employee 表包含所有员工信息，每个员工有其对应的 Id, salary 和 department Id。
--
-- +----+-------+--------+--------------+
-- | Id | Name  | Salary | DepartmentId |
-- +----+-------+--------+--------------+
-- | 1  | Joe   | 70000  | 1            |
-- | 2  | Henry | 80000  | 2            |
-- | 3  | Sam   | 60000  | 2            |
-- | 4  | Max   | 90000  | 1            |
-- +----+-------+--------+--------------+
-- Department 表包含公司所有部门的信息。
--
-- +----+----------+
-- | Id | Name     |
-- +----+----------+
-- | 1  | IT       |
-- | 2  | Sales    |
-- +----+----------+
-- 编写一个 SQL 查询，找出每个部门工资最高的员工。例如，根据上述给定的表格，Max 在 IT 部门有最高工资，Henry 在 Sales 部门有最高工资。
--
-- +------------+----------+--------+
-- | Department | Employee | Salary |
-- +------------+----------+--------+
-- | IT         | Max      | 90000  |
-- | Sales      | Henry    | 80000  |
-- +------------+----------+--------+

-- 解法一：使用内连接把部门最高和名称关联到员工表

select
    Department.Name as Department,
    Employee.Name as Employee,
    Employee.Salary as Salary
from
    Employee
    inner join
    (select DepartmentId, max(Salary) as max_salary from Employee group by DepartmentId) t_max_salary
    on Employee.DepartmentId=t_max_salary.DepartmentId
    inner join
    Department
    on Employee.DepartmentId=Department.Id
where Employee.Salary=t_max_salary.max_salary

-- 解法二：使用行比较，部门id和salary
select
    b.Name as Department ,
    a.Name as Employee ,
    a.Salary as Salary
from Employee a left join Department b on a.DepartmentId = b.Id
where
    (b.Id,a.Salary) in
    (select DepartmentId, max(Salary) as Salary from Employee group by DepartmentId)

