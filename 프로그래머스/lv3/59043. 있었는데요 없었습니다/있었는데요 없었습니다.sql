-- 코드를 입력하세요
# SELECT I.ANIMAL_ID, I.NAME
# FROM ANIMAL_INS AS I JOIN ANIMAL_OUTS AS O ON I.ANIMAL_ID = O.ANIMAL_ID
# WHERE DATE(I.DATETIME) > DATE(O.DATETIME)
# ORDER BY I.DATETIME ASC

SELECT I.ANIMAL_ID, IF(I.NAME IS NULL,O.NAME, I.NAME) AS NAME
FROM ANIMAL_INS AS I JOIN ANIMAL_OUTS AS O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE I.DATETIME >= O.DATETIME
ORDER BY I.DATETIME ASC