-- 小美是一所中学的信息科技老师，她有一张 seat 座位表，平时用来储存学生名字和与他们相对应的座位 id。
--
-- 其中纵列的 id 是连续递增的
--
-- 小美想改变相邻俩学生的座位。
--
-- 你能不能帮她写一个 SQL query 来输出小美想要的结果呢？
--
--
--
-- 示例：
--
-- +---------+---------+
-- |    id   | student |
-- +---------+---------+
-- |    1    | Abbot   |
-- |    2    | Doris   |
-- |    3    | Emerson |
-- |    4    | Green   |
-- |    5    | Jeames  |
-- +---------+---------+
-- 假如数据输入的是上表，则输出结果如下：
--
-- +---------+---------+
-- |    id   | student |
-- +---------+---------+
-- |    1    | Doris   |
-- |    2    | Abbot   |
-- |    3    | Green   |
-- |    4    | Emerson |
-- |    5    | Jeames  |
-- +---------+---------+
-- 注意：
--
-- 如果学生人数是奇数，则不需要改变最后一个同学的座位。
-- 1

SELECT IF(id%2<>0, IF(id<>(SELECT COUNT(*) FROM seat), id+1, id), id-1) id,student
  FROM seat
 ORDER BY id
-- 2
select (case when mod(id, 2)=1 and id = t_max.max_id then id
       when mod(id, 2)=1 and id <> t_max.max_id then id+1
       else id -1
       end) id, student from seat, (select max(id) max_id from seat) t_max order by id