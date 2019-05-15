-- 编写一个 SQL 查询，查找 Person 表中所有重复的电子邮箱。
--
-- 示例：
--
-- +----+---------+
-- | Id | Email   |
-- +----+---------+
-- | 1  | a@b.com |
-- | 2  | c@d.com |
-- | 3  | a@b.com |
-- +----+---------+
-- 根据以上输入，你的查询应返回以下结果：
--
-- +---------+
-- | Email   |
-- +---------+
-- | a@b.com |
-- +---------+
select
    Email
from (
    select
        Email,
        count(1) as num
    from Person
    group by
        Email) tmp_table
where tmp_table.num > 1;

-- 时间 322
select Email from Person group by Email having count(1) >1;

