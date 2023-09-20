SELECT FIRST_NAME, SALARY, SALARY*IFNULL(COMMISSION_PCT, 0)
FROM employees;

SELECT e.FIRST_NAME, d.department_name
FROM employees E, departments D
WHERE BINARY(FIRST_NAME) LIKE '%M%'
AND E.department_id = D.department_id;

SELECT e.FRIST_NAME, d.department_name
FROM employees E, departments D
WHERE FIRST_NAME LIKE BINARY '%A%'
AND E.department_id = D.DEPARTMENT_ID;

SELECT E.FIRST_NAME, J.JOB_TITLE
FROM employees E, jobs J
WHERE E.job_id = j.job_id
AND j.job_title NOT IN('Accountant', 'programmer');

SELECT E.FIRST_NAME, J.JOB_TITLE, J.MIN_SALARY
FROM employees E, jobs J
WHERE E.job_id = J.job_id
AND J.job_title IN(
						SELECT job_title
						FROM JOBS
						WHERE MIN_SALARY > 7000
						);
						
-- INSERT, UPDATE, DELETE
-- COMMIT, ROLLBACK
SELECT @@AUTOCOMMIT;
SET autocommit = TRUE;
SET autocommit = FALSE;


-- 16. 사원의 이름(LAST_NAME)이 'Abel'인 사원과 같은 부서에서 근무하는
-- 사원의 이름과 부서번호를 출력하시오(abel 이 같이 나오면 곤란함)

SELECT e1.last_name, e1.department_id
FROM employees e1
WHERE department_id = (
						SELECT department_id
						FROM employees e2
						WHERE last_name LIKE 'Abel'
						);
AND e1.last_name != 'Abel'

SELECT E1.last_name, E.department_id
FROM employees E LEFT JOIN employees E1
ON E.department_id = E1.department_id
WHERE E.last_name = 'Abel'
AND E.last_name != E1.last_name;
						
						
/* INSERT : 테이블(뷰)에 데이터를 입력
	UPDATE : 테이블의 값을 수정
	DELETE : 테이블의 값을 삭제
	
	INSERT INTO 테이블 이름(컬럼명, 컬럼명 ,,,) VALUES(값, 값, ...)
	INSERT INTO 테이블 이름 VALUES(값, 값, ...)
	
	UPDATE 테이블
	WHERE 컬럼명 = 값, 컬럼명 = 값, ...
	WHERE ..*/

INSERT INTO employees
VALUES(300, 'A', 'A', 'A', 'A', '2011-01-01', 'AD_VP', 8000, NULL, 111, 80);

ROLLBACK;

UPDATE employees
SET FIRST_NAME = 'bbbB', LAST_NAME = '43532'
WHERE EMPLOYEE_ID = 300;

ROLLBACK;

DELETE
FROM employees
WHERE employee_id = 300;

COMMIT;

ROLLBACK;

-- DDL : CREATE, ALTER, DROP
-- 테이블 만들기
CREATE TABLE BBS(
	ARTICLE_NUMBER INT AUTO_INCREMENT PRIMARY KEY,
	WRITER_ID VARCHAR(30) NOT NULL,
	TITLE VARCHAR(200) hrNOT NULL,
	CONTENTS VARCHAR(10000) NOT NULL,
	WRITE_DATE DATETIME NOT NULL
	);
	
CREATE TABLE COMMENTS(
	COMMENT_NUM INT AUTO_INCREMENT PRIMARY KEY,
	WRITER_ID VARCHAR(30) NOT NULL,
	CONTENTS VARCHAR(1500) NOT NULL,
	ARTICLE_NUMBER INT NOT NULL,
	
	CONSTRAINT `COMM_ARTICL_FK` FOREIGN KEY(`ARTICLE_NUMBER`) REFERENCES BBS(`ARTICLE_NUMBER`)
);
	
ROLLBACK;

INSERT INTO BBS
VALUES(NULL, 'A', 'A', 'A', NOW());
INSERT INTO BBS
VALUES(NULL, 'A', 'A', 'A', SYSDATE());

INSERT INTO	comments
VALUES(NULL, 'A', 'A', 3);

CREATE OR REPLACE VIEW EMP
AS
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM employees;

CREATE OR REPLACE VIEW EMP1
AS
SELECT FIRST_NAME, LAST_NAME, SALARY
FROM employees
WHERE 1 = 2;

-- 제약조건 이름 확인할 수 있는 뷰
SELECT *
FROM information_schema.TABLE_CONSTRAINTS;

SELECT NOW()-HIRE_DATE
from employees;

SELECT CONCAT(CONCAT(CONCAT(FIRST_NAME, '는'), SALARY), '입니다')
FROM employees;

SELECT NOW();
SELECT SYSDATE();
SELECT NOW(), SLEEP(5), CURRENT_TIMESTAMP();
SELECT CURRENT_TIMESTAMP;



	
