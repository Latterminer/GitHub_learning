-- 编写一个 SQL 查询，查找所有至少连续出现三次的数字。
--
-- +----+-----+
-- | Id | Num |
-- +----+-----+
-- | 1  |  1  |
-- | 2  |  1  |
-- | 3  |  1  |
-- | 4  |  2  |
-- | 5  |  1  |
-- | 6  |  2  |
-- | 7  |  2  |
-- +----+-----+
-- 例如，给定上面的 Logs 表， 1 是唯一连续出现至少三次的数字。
--
-- +-----------------+
-- | ConsecutiveNums |
-- +-----------------+
-- | 1               |
-- +-----------------+
select t1.Num from Logs t1 Logs t2 Logs t3 where t1.Id = t2.Id+1 and t1.Id = t3.Id+2 and t1.Num = t2.Num and t.Num = t3.Num


-- # Write your MySQL query statement below
select distinct Num as ConsecutiveNums from
(
select
    Num,
    @cnt:=if(@pre=num,@cnt:=@cnt+1,@cnt:=1) as n,
    @pre:=Num from Logs,
    (select @pre := -1,@cnt := 0)as init
)as t
where t.n>=3;


select distinct Num as ConsecutiveNums
from (
  select Num,
    case
      when @prev = Num then @count := @count + 1
      when (@prev := Num) is not null then @count := 1
    end as CNT
  from Logs, (select @prev := null,@count := null) as t
) as temp
where temp.CNT >= 3