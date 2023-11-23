-- 코드를 입력하세요
# SELECT month(start_date) as month, car_id, count(*) as records

SELECT
MONTH(START_DATE) MONTH,
CAR_ID,
COUNT(*) RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE BETWEEN "2022-08-01" AND "2022-10-31"
    GROUP BY CAR_ID
    HAVING COUNT(*) >= 5
) AND START_DATE BETWEEN "2022-08-01" AND "2022-10-31"
GROUP BY MONTH(START_DATE), CAR_ID
ORDER BY MONTH, CAR_ID DESC;
# select distinct month(start_date) as month, a.car_id, t.records
# from (car_rental_company_rental_history as a join
# (Select car_id, count(*) as records
# from car_rental_company_rental_history
# where (month(start_date) between 8 and 10 )
# group by car_id
# having count(*) >= 5) as t
# on a.car_id = t.car_id)
# where t.
# order by month, car_id desc;