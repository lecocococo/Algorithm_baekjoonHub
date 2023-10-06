-- 코드를 입력하세요
SELECT M.MEMBER_NAME, R.REVIEW_TEXT, SUBSTRING_INDEX(R.REVIEW_DATE, ' ', 1) AS REVIEW_DATE
FROM MEMBER_PROFILE AS M RIGHT OUTER JOIN REST_REVIEW AS R ON M.MEMBER_ID = R.MEMBER_ID
WHERE M.MEMBER_ID IN (
    SELECT MEMBER_ID
    FROM (
        SELECT *
        FROM (SELECT MEMBER_ID, COUNT(*) AS CNT
            FROM REST_REVIEW AS R
            GROUP BY MEMBER_ID) AS K
        WHERE CNT = (SELECT MAX(CNT) FROM (SELECT MEMBER_ID, COUNT(*) AS CNT
            FROM REST_REVIEW AS R
            GROUP BY MEMBER_ID) AS O )
        ) AS U
    )
ORDER BY R.REVIEW_DATE ASC , R.REVIEW_TEXT ASC;

