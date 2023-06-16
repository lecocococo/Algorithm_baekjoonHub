-- 코드를 입력하세요
SELECT u.user_id as USER_ID, u.nickname as NICKNAME, sum(g.price) as TOTAL_SALES
from USED_GOODS_BOARD as g join USED_GOODS_USER as u on g.writer_id = u.user_id
where g.status like ("DONE")
group by g.writer_id
having sum(g.price) >= 700000
order by TOTAL_SALES ASC