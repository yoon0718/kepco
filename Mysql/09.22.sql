CREATE TABLE BOARD (
 SEQ_NO INT
 , TITLE VARCHAR(50)
 , CONTENT VARCHAR(100)
 , CODE VARCHAR(1)
);
INSERT INTO BOARD VALUES (1, '첫번째 공지사항', '공지사항 입니다', 'N');
INSERT INTO BOARD VALUES (2, '첫번째 FAQ', 'FAQ 입니다', 'F');
INSERT INTO BOARD VALUES (3, '첫번째 자료', '자료실 입니다', 'D');
INSERT INTO BOARD VALUES (4, '첫번째 QnA', 'QnA 입니다', 'Q');
INSERT INTO BOARD VALUES (5, '1번 게시글', '1번 게시글입니다', 'A');
INSERT INTO BOARD VALUES (6, '2번 게시글', '두번째 게시글입니다', 'A');

CREATE TABLE BOARD_CODE (
 CODE VARCHAR(1)
 , CODE_EXP VARCHAR(100)
 , USE_YN VARCHAR(1)
);
INSERT INTO BOARD_CODE VALUES ('N', '공지사항', 'Y');
INSERT INTO BOARD_CODE VALUES ('F', 'FAQ', 'Y');
INSERT INTO BOARD_CODE VALUES ('D', '자료실', 'N');
INSERT INTO BOARD_CODE VALUES ('Q', 'QnA', 'Y');
INSERT INTO BOARD_CODE VALUES ('A', '일반게시판', 'Y');

CREATE TABLE BOARD_FILE (
 FILE_SEQ_NO INT
 , BOARD_SEQ_NO INT
 , FILE_NAME VARCHAR(50)
 , FILE_SIZE INT
);
INSERT INTO BOARD_FILE VALUES (1, 1, '공지사항.hwp', 12345678);
INSERT INTO BOARD_FILE VALUES (2, 2, 'FAQ자료.zip', 10000000);
INSERT INTO BOARD_FILE VALUES (3, 5, 'readme.txt', 1000);

COMMIT;

SELECT d.seq_no, d.title, d.content, e.code, e.code_exp
FROM board d, board_code e
WHERE d.code = e.code
AND e.use_yn LIKE '%Y%';

SELECT *
FROM visitor_tb;

-- visitor_data.sql에서 데이터 긁어오기

-- 2017.05 ~ 2020.01 전체 방문자수
SELECT COUNT(*)
FROM visitor_tb
WHERE visitor_tb BETWEEN '2017-05-01' AND '2020-01-31';

-- 방문횟수 2번 이상인 ip
SELECT ip_address, COUNT(*)
FROM visitor_tb
GROUP BY ip_address
HAVING COUNT(*) >= 2
ORDER BY COUNT(*) DESC;

-- 연도별 방문자 현황
SELECT DATE_FORMAT(vst_time, '%Y'), COUNT(*)
FROM visitor_tb
GROUP BY DATE_FORMAT(vst_time, '%Y');

-- 전체기간 중 월별 방문자 현황
-- 방문자 수 내림차순 정렬

SELECT DATE_FORMAT(vst_time, '%m') AS date, COUNT(*)
FROM visitor_tb
GROUP BY date
ORDER BY COUNT(*) DESC;

-- 방문경로별 방문자 현황
-- 방문경로 1:검색 2:부산관광공사

SELECT DATE_FORMAT(vst_time, '%Y-%m') AS 방문월, 
		 case vst_path 
		 when 1 then '검색'
		 when 2 then '부산관광공사'
		 END AS 방문경로,
		 COUNT(*) AS 방문자수
FROM visitor_tb
GROUP BY DATE_FORMAT(vst_time, '%Y-%m'), 방문경로
ORDER BY 방문월;

-- 자주 검색된 태그 상위 2개 확인
-- >('해운대', '서면')

SELECT tag_NAME, hit_cnt
FROM tag_tb
ORDER BY hit_cnt DESC
LIMIT 0, 2;

-- 가장 많이 검색된 태그를 사용하는 매장 개수 확인
-- > 44

SELECT COUNT(*)
FROM shop_tag_tb stt, tag_tb tt, shop_tb st
WHERE stt.TAG_ID = tt.TAG_ID
AND st.SHOP_ID = stt.SHOP_ID
AND tt.HIT_CNT IN (
						SELECT MAX(hit_cnt)
						FROM tag_tb
						);

SELECT COUNT(*)
FROM shop_tag_tb stt, tag_tb tt
WHERE stt.TAG_ID = tt.TAG_ID
AND tt.tag_id = (
						SELECT tag_id
						FROM tag_tb
						ORDER BY hit_cnt desc
						LIMIT 0, 1
						);
-- '거북선횟집'매장에 연결된 모든 태그명 확인
-- > 부산, 해운대구, 해운대, 미포, 거북선횟집, 모듬회, 바다보이는집, 단체, 모임, 한식

SELECT tt.TAG_NAME
FROM shop_tag_tb stt, tag_tb tt, shop_tb st
WHERE stt.TAG_ID = tt.TAG_ID
AND st.SHOP_ID = stt.SHOP_ID
AND st.SHOP_NAME LIKE '%거북선횟집%';

-- '한구름' 사용자가 즐겨찾기로 등록된 매장명과 매장의 설명 확인
-- > 디딤돌 싱싱한 굴과 고소한 보쌈 전문점 / 해림 꽃새우 회 전문점

SELECT *
FROM shop_tb st, favorite_tb ft, user_tb ut
WHERE st.SHOP_ID = ft.SHOP_ID
AND ft.USER_ID = ut.USER_ID
AND ut.USER_NAME LIKE '%한구름%';

-- 아이디가 64인 매장을 즐겨찾기로 등록된 사용자의 이름과 이메일 주소 확인
-- > 김명 windo@gmail.com / 양말 liox2xoil@nate.com

SELECT ut.USER_NAME, ut.EMAIL
FROM shop_tb st, favorite_tb ft, user_tb ut
WHERE st.SHOP_ID = ft.SHOP_ID
AND ft.USER_ID = ut.USER_ID
AND st.shop_id = 64;

SELECT COUNT(4)
FROM tag_tb
GROUP BY hit_cnt;

-- 09.22 mysql 시험답
SELECT *
FROM employees;

SELECT first_name,
		 salary, 
		 case 
			when commission_pct IS NULL then 0
			ELSE commission_pct
			END AS connission_pct,
		 case 
		 	when commission_pct IS NULL then salary
		 	ELSE salary + salary*commission_pct
		 	END AS sum
FROM employees;


SELECT first_name
FROM employees
WHERE commission_pct IS NULL;

SELECT First_name, department_id
FROM employees
WHERE first_name LIKE 's%'
ORDER BY department_id DESC;

SELECT department_id, AVG(salary)
FROM employees
GROUP BY department_id
HAVING AVG(salary) >= 2000;

SELECT e.first_name, e.department_id, d.department_name, l.city
FROM employees e, departments d, locations l, jobs j
WHERE e.department_id = d.department_id
AND e.job_id = j.job_id
AND d.location_id = l.location_id
AND j.job_title = 'Stock Clerk';














