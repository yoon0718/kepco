SELECT FIRST_NAME, SUBSTR(FIRST_NAME, 2, 2)
FROM employees;

-- datediff(일수로 나옴)
SELECT HIRE_DATE, DATEDIFF(NOW(), HIRE_DATE)
FROM employees;

-- 모든 사원의 근무 년수를 출력(년수만) TRUNCATE, CONCAT 사용
-- 25년

SELECT HIRE_DATE, DATE_FORMAT(HIRE_DATE, '%Y')
FROM employees;

SELECT HIRE_DATE, CONCAT(TRUNCATE((DATEDIFF(NOW(), HIRE_DATE)/365),0),'년')
FROM employees;

-- 3개월 .. 출력 MOD

SELECT CONCAT(TRUNCATE(MOD(DATEDIFF(NOW(), HIRE_DATE),365)/30,0),'개월')
FROM employees;

SELECT FIRST_NAME, SALARY
		, case when JOB_ID = 'IT_PROG' then salary * 1.1
				 when JOB_ID = 'ST_MAN' then salary * 1.2
				 when JOB_ID = 'SA_MAN' then salary * 1.3
				 ELSE salary
				 END AS '보너스 포함'
FROM employees;

-- 그룹함수
-- : 특정 속성의 값이 같은 튜플을 모아 그룹을 만들어 그룹별로 모으는 함수
-- : SELECT 절에는 그룹으로 묶은 속성과 그룹함수만 사용 가능
-- : HAVING절을 사용하여 GROUP BY절의 조건 작성


-- 부하직원이 1명인 사수의 사원번호 검색(사수가 없는 사원은 제외)
SELECT e1.manager_id, COUNT(*)
FROM employees e1
WHERE e1.manager_id IS NOT null
GROUP BY e1.manager_id
HAVING COUNT(*) = 1;

USE HR;
SHOW DATABASE;
SHOW TABLE;
SHOW DATABASES
SHOW USER;

-- ROOT로 명령어 실행
CREATE USER 'yoon'@'localhost' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON HR.* TO 'yoon'@'LOCALHOST';
ALTER USER 'yoon'@'localhost' IDENTIFIED BY '1234';
DROP USER 'yoon'@'localhost';

SELECT @@AUTO_INCREMENT_INCREMENT;
SET @@AUTO_INCREMENT_INCREMENT=10;

CREATE INDEX EMP_IDX ON employees(FIRST_NAME);
DROP INDEX EMP_IDX ON employees;
SHOW INDEX FROM employees;

SELECT *
FROM EMP_IDX;
	
CREATE TABLE SCHOOL(
	NUM INT AUTO_INCREMENT PRIMARY KEY,
	NAME VARCHAR(50) NOT NULL,
	AREA VARCHAR(50) NOT NULL,
	COURSE_CNT INT NOT NULL,
	C_DATE DATETIME NOT null
	);

CREATE TABLE COURSE01(
	NUM INT AUTO_INCREMENT PRIMARY KEY,
	SCHOOL_NUM INT NOT NULL,
	NAME VARCHAR(15) NOT NULL,
	STUDENT_CNT INT NOT NULL,
	C_DATE DATETIME NOT null
	);
	
INSERT INTO SCHOOL (NUM, NAME, AREA, COURSE_CNT, C_DATE)
VALUES(NULL, '서울대학교', '서울', 35, '80/07/01'),
(NULL, '중앙대학교', '서울',27, '81/08/01'),
(NULL, '동아대학교', '부산',32, '82/09/01'),
(NULL, '부산대학교', '부산',21, '83/10/01');

INSERT INTO COURSE01 (NUM, SCHOOL_NUM, NAME, STUDENT_CNT, C_DATE)
VALUES(NULL, 4, 'IT', 50, '00/07/09'),
(NULL, 3, '경영', 60, '10/01/01'),
(NULL, 2, '식품영양', 70, '09/03/01'),
(NULL, 1, '화학', 80, '08/05/01');

SELECT *
FROM SCHOOL;

SELECT *
FROM COURSE01;

SELECT *
FROM SCHOOL
WHERE NAME LIKE '%서울%'
AND AREA LIKE '%서울%';

SELECT *
FROM SCHOOL
WHERE DATE_FORMAT(C_DATE, '%m') LIKE '%08%';

-- 학교번호(school_num)가 1이면 부산대 2이면 중앙대 3이면 ,,, 으로 출력
SELECT *, case SCHOOL_NUM when 1 then '서울대학교'
				when 2 then '중앙대학교'
				when 3 then '동아대학교'
				when 4 then '부산대학교'
				END AS '대학교'
FROM COURSE01;

create table dept (
	deptno tinyint primary key,
	dname varchar(14),
	loc varchar(13)
);


create table emp (
	empno int,
	ename varchar(10),
	job varchar(9),
	mgr int,
	hiredate datetime,
	sal int,
	comm ihrhrhrhrnt,
	deptno tinyint,
	primary key(empno),
	constraint fk_emp_dept
	foreign key(deptno) references dept(deptno)
	on delete cascade
);

insert into dept values (10, 'accounting', 'new york');
insert into dept values (20, 'research',   'dallas');
insert into dept values (30, 'sales',      'chicago');
insert into dept values (40, 'operations', 'boston');

insert into emp values
        (7369, 'smith',  'clerk',     7902,
        '1980-12-17',  800, null, 20);
insert into emp values
        (7499, 'allen',  'salesman',  7698,
        '1981-02-20', 1600,  300, 30);
insert into emp values
        (7521, 'ward',   'salesman',  7698,
        '1981-02-22', 1250,  500, 30);
insert into emp values
        (7566, 'jones',  'manager',   7839,
        '1981-04-02',  2975, null, 20);
insert into emp values
        (7654, 'martin', 'salesman',  7698,
        '1981-09-28', 1250, 1400, 30);
insert into emp values
        (7698, 'blake',  'manager',   7839,
        '1981-05-01',  2850, null, 30);
insert into emp values
        (7782, 'clark',  'manager',   7839,
        '1981-06-09',  2450, null, 10);
insert into emp values
        (7788, 'scott',  'analyst',   7566,
        '1982-12-09', 3000, null, 20);
insert into emp values
        (7839, 'king',   'president', null,
        '1981-11-17', 5000, null, 10);
insert into emp values
        (7844, 'turner', 'salesman',  7698,
        '1981-09-08',  1500,    0, 30);
insert into emp values
        (7876, 'adams',  'clerk',     7788,
        '1983-01-12', 1100, null, 20);
insert into emp values
        (7900, 'james',  'clerk',     7698,
        '1981-12-03',   950, null, 30);
insert into emp values
        (7902, 'ford',   'analyst',   7566,
        '1981-12-03',  3000, null, 20);
insert into emp values
        (7934, 'miller', 'clerk',     7782,
        '1982-01-23', 1300, null, 10);
        
-- 교통사고사망자
DROP TABLE IF EXISTS `ACCIDENT` RESTRICT;

-- 교통사고사망자
CREATE TABLE `ACCIDENT` (
	`ID`    INT         NOT NULL COMMENT '아이디', -- 아이디
	`YEAR`  INT         NOT NULL COMMENT '발생년도', -- 발생년도
	`AMPM`  VARCHAR(2)  NOT NULL COMMENT '주간야간', -- 주간야간
	`WEEK`  VARCHAR(1)  NOT NULL COMMENT '발생요일', -- 발생요일
	`DIE`   INT         NOT NULL COMMENT '사망자수', -- 사망자수
	`AREA1` VARCHAR(10) NOT NULL COMMENT '발생지 시도', -- 발생지 시도
	`AREA2` VARCHAR(10) NOT NULL COMMENT '발생지 시군구', -- 발생지 시군구
	`KIND`  VARCHAR(50) NOT NULL COMMENT '사고유형' -- 사고유형
)
COMMENT '교통사고사망자';

-- 교통사고사망자
ALTER TABLE `ACCIDENT`
	ADD CONSTRAINT `PK_ACCIDENT` -- 교통사고사망자 기본키
		PRIMARY KEY (
			`ID` -- 아이디
		);

ALTER TABLE `ACCIDENT`
	MODIFY COLUMN `ID` INT NOT NULL AUTO_INCREMENT COMMENT '아이디';
	

SELECT WEEK, SUM(DIE)
FROM accident
GROUP BY WEEK;   

SELECT AREA1, SUM(DIE)
FROM accident
GROUP BY AREA1 
ORDER BY AREA1 ASC;

SELECT AREA1, AREA2, SUM(DIE)
FROM accident
GROUP BY AREA1, AREA2
ORDER BY AREA1, AREA2;

SELECT KIND, COUNT(*)
FROM accident
GROUP BY KIND
ORDER BY COUNT(*) DESC
LIMIT 0, 5;

SELECT WEEK, COUNT(DIE)
FROM accident
GROUP BY WEEK
ORDER BY COUNT(DIE)
LIMIT 1;

-- EMP와 DEPT 테이블을 조인하여
-- 사원명, 부서번호, 부서명 검색

SELECT e.ENAME, d.DEPTNO, d.DNAME
FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- EMP와 DEPT 테이블을 조인하여
-- 모든 속성 검색
SELECT *
FROM emp e, dept d
WHERE e.deptno = d.deptno;

-- 보너스가 NULL이 아닌 사원의 사원명, 
-- 보너스, 급여, 부서위치 검색

SELECT e.ename, e.comm, e.sal, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND e.comm IS NOT NULL;

-- 부서위치가 'NEW YORK' 이거나 'DALLAS'인
-- 부서에 근무하는 사원들의 부서별 
-- 급여합계와 부서명 검색
SELECT SUM(e.sal), d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND d.loc IN ('new york', 'dallas')
GROUP BY d.dname;

-- IT_MEMBER / COURSE02 테이블 
-- COURSE_NO를 기준으로 LEFT OUTER JOIN
COMMIT;

SELECT *
FROM it_member i LEFT OUTER JOIN course02 c ON i.COURSE_NO = c.COURSE_NO;

SELECT *
FROM it_member i RIGHT OUTER JOIN course02 c ON i.COURSE_NO = c.COURSE_NO;













