-- 코드를 입력하세요
SELECT CATEGORY, sum(a.s) as TOTAL_SALES
from (SELECT book_id, sum(sales) as s
from BOOK_SALES
where sales_date between '2022-01-01'and '2022-01-31'
group by book_id) as a join book as b on a.book_id = b.book_id
group by category
order by category
