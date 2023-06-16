-- 코드를 입력하세요
SELECT ingredient_type, sum(total_order) as TOTAL_ORDER
from first_half as f left join icecream_info as i on f.flavor = i.flavor
group by ingredient_type
;