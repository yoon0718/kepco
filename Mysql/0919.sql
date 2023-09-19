/*1.DDL(DATA DEFINITION LANGUAGE) : CREATE, ALTER, DROP
  2.DML(DATA manupulation LANGUAGE) : SELECTdepartments , INSERT, UPDATE, DELETE
  -- 3.dcl(DATA control LANGUAGE) : GRANT , revoke */
  
  /*SELECT FIRST_NAME
  FROM employees */
  
 /* SELECT 컬럼이름, 컬럼이름...
  FROM 테이블 또는 뷰
  WHERE 조건절
  GROUP BY
  ODERY BY employees */
  
 /* SELECT DEPARTMENT_ID, AVG(SALARY)
  FROM EMPLOYEES
  GROUP BY DEPARTMENT_ID; 
  
  SELECT FIRST_NAME
  FROM EMPLOYEES
  ORDER BY FIRST_NAME DESC;*/
  
  SELECT FIRST_NAME
  FROM EMPLOYEES
  WHERE EMPLOYEE_ID =103;
  
  SELECT 5*6
  FROM DUAL ;
  
  급여가 5000이상 10000 미만인 사원의 이름과 급여를 출력하시오
  SELECT FIRST_NAME, SALARY
  FROM EMPLOYEES
  WHERE SALARY >5000 AND SALARY <10000;
  
  SELECT FIRST_NAME, SALARY
  FROM EMPLOYEES
  WHERE SALARY BETWEEN 5000 AND 10000;
  
 -- 9.19일 수업 
  
  SELECT DISTINCT FIRST_NAME
  FROM EMPLOYEES;
  
  SELECT FIRST_NAME AS "사원 이름"
  FROM employees;
  
  SELECT FIRST_NAME  사원이름
  FROM employees;
  
  SELECT FIRST_NAME  사원이름
  FROM employees;
  
  SELECT FIRST_NAME
  FROM EMPLOYEES
  WHERE FIRST_NAME LIKE '%j%';
  
  -- MYSQL은 대소문자 구분을 안함, ORACLE은 대소문자 구분을 함
  
  -- % : 1번 이상 나올수 있고 안나와도됨
  
  -- _ : 반드시 나와야되고 1번만옴
  
  
  SELECT FIRST_NAME, LAST_NAME
  FROM EMPLOYEES
  ORDER BY FIRST_NAME, LAST_NAME DESC;
  
 -- 1. FIRST_NAME에 A가 들어가는 사원들의 이름을 출력하시오
 -- 2. 이름과 월급을 출력하는데 월급이 낮은사원부터 옾은 사원순으로 출력
    
  -- JOIN 
 -- 3. 사원번호가 110인 사원의 FIRST_NAME과 부서이름(DEPARTMENT_NAME)을 출력
    SELECT e.FIRST_NAME, d.department_name
    FROM employees E, departments D
    WHERE e.employee_id=110
      AND E.department_id= D.DEPARTMENT_ID;
  
-- 4. 모든 사원의 FIRST_NAME과 부서이름(DEPARTMENT_NAME)을 출력
--  JOIN하는 컬럼에 NULL 값이 있음.OUTER JOIN 으로 해결해야함
    SELECT e.FIRST_NAME, d.department_name
    FROM employees E, departments D
    WHERE E.department_id= D.DEPARTMENT_ID;
    
 -- 5. 사원번호 108번인 사원의 이름과 사수의 이름, 사수의 사원번호를 출력하시오
 --   SELF-JOIN, 테이블을 선언할때 반드시 익명을 써야함
    SELECT E1.first_name AS "사원이름", E2.employee_id, E2.first_name AS "사수이름"
    FROM employees E1, employees E2
    WHERE E1.employee_id=108
      AND E1.MANAGER_ID = E2.employee_id;
 -- 6. FIRST_NAME에 Z가 들어가는 사원의 이름과 부서이름을 출력하시오
    SELECT e.FIRST_NAME, d.department_name
    FROM employees E, departments D
    WHERE FIRST_NAME LIKE '%Z%'
	   AND E.department_id= D.DEPARTMENT_ID;
	   
  -- 7. 부서이름(CITY)이 'Toronto'인 사원의 이름 부서이름을 출력하시오
    SELECT e.FIRST_NAME, d.department_name
    FROM employees E, departments D, locations L
    WHERE L.city='Toronto'
	   AND E.department_id= D.DEPARTMENT_ID
	   AND D.location_id = L.location_id;
 
   SELECT FIRST_NAME
   FROM EMPLOYEES
  -- WHERE DEPARTMENT_ID = NULL;
   WHERE DEPARTMENT_ID IS NULL;
  -- WHERE DEPARTMENT_ID IS NOT NULL;
   
   SELECT FIRST_NAME, COMMISSION_PCT
   FROM EMPLOYEES
   WHERE COMMISSION_PCT IS NOT NULL;
 
 -- 8. 모든 사원의 급여와 상여금(SALARY *COMMISSION_PCT)을 출력하시요
   SELECT FIRST_NAME, SALARY, SALARY*COMMISSION_PCT
   FROM employees;
   
   SELECT FIRST_NAME, DEPARTMENT_ID
   FROM EMPLOYEES
   WHERE DEPARTMENT_ID !=20;  -- <>
  
 -- 9. 부서이름(CITY)이 'Toronto'인 사원의 이름 부서이름을 출력하시오
 -- 서브쿼리 사용
    SELECT e.FIRST_NAME, d.department_name
    FROM employees E, departments D
    WHERE E.department_id= D.DEPARTMENT_ID
	   AND D.location_id =(SELECT LOCATION_ID
	     						  FROM LOCATIONS
	      					  WHERE CITY='Toronto'
	       					 );
-- 4.1 모든 사원의 FIRST_NAME과 부서이름(DEPARTMENT_NAME)을 출력
--  ANSI SQL 으로 해결해야함
    SELECT e.FIRST_NAME, d.department_name
    FROM employees E JOIN departments D
         ON E.department_id= D.DEPARTMENT_ID;
-- 10.평균급여보다 많이 받는 사원의 이름과 급여출력
-- AVG(SALARY)
   SELECT LAST_NAME, SALARY
   FROM EMPLOYEES
   WHERE SALARY > (SELECT AVG(SALARY)
	                FROM employees);  
-- 11. 'Ernst'(LAST_NAME)의 급여와 동일하거나 더 많이 받는 사원의 
--      이름과(LAST_NAME) 급여를 출력하시오
   SELECT LAST_NAME, SALARY
   FROM EMPLOYEES
   WHERE SALARY > (SELECT SALARY
	                FROM employees
						 WHERE LAST_NAME='Ernst'); 
-- 12. 11번 문제를 JOIN으로 풀어보시오
   SELECT E1.LAST_NAME, E1.SALARY
   FROM employees E, employees E1
   WHERE E.last_name='Ernst'
     AND E.SALARY < E1.SALARY ;

-- 13. 부서번호가 30인 부서에 근무하는 사원들의 이름, 부서위치(CITY), 
--     직급(JOB_TITLE)을 출력하시오
   SELECT E.FIRST_NAME, L.CITY, J.JOB_TITLE
   FROM employees E, departments D, locations L, jobs J
   WHERE E.department_id =30
     AND E.department_id = D.department_id
     AND D.location_iD = L.location_id
     AND E.job_id = J.job_id;
   
   SELECT COUNT(*)
   FROM EMPLOYEES
   WHERE DEPARTMENT_ID=30;

-- 14. 직급(JOB_TITLE)이 'Accountant' 도 아니고 'Programmar' 도 아닌 
--      사람을 출력하시오 
   
   SELECT E.FIRST_NAME, J.JOB_TITLE
   FROM employees E, jobs J
   WHERE E.JOB_ID= J.JOB_ID
	  AND J.JOB_TITLE != 'Accountant'
     AND J.JOB_TITLE <> 'Programmer';
   
   
   -- IN은 OR의 개념
   SELECT E.FIRST_NAME, J.JOB_TITLE
   FROM employees E, jobs J
   WHERE E.JOB_ID= J.JOB_ID
	  AND J.JOB_TITLE NOT IN('Accountant','Programmer');
   
   -- LIMI은 0부터 시작
   SELECT FIRST_NAME
   FROM employees 	  
   ORDER BY FIRST_NAME
	LIMIT 5,3;   
	
	SELECT e.FIRST_NAME, d.department_name
   FROM employees E JOIN departments D
     ON E.department_id= D.DEPARTMENT_ID;
     
-- Outer JOIN
    SELECT e.FIRST_NAME, d.department_name
    FROM employees E LEFT OUTER JOIN departments D
    ON E.department_id= D.DEPARTMENT_ID;
    
/*	 UNION
    SELECT e.FIRST_NAME, d.department_name
    FROM employees E RIGHT OUTER JOIN departments D
    ON E.department_id= D.DEPARTMENT_ID; */
   
-- 15. 모든 사원의 이름, 부서위치(CITY),직급(JOB_TITLE)을 출력하시오
   SELECT E.FIRST_NAME, L.CITY, J.JOB_TITLE
   FROM employees E 
	LEFT JOIN departments D  
   ON E.department_id = D.department_id
   LEFT JOIN LOCATIONS L
	ON D.location_id = L.location_id
	JOIN jobs J
   ON E.job_id = J.job_id;
   
   SELECT E.FIRST_NAME, L.CITY, J.JOB_TITLE
   FROM employees E LEFT JOIN (departments D, locations L, jobs J) 
   ON E.department_id = D.department_id
   AND D.location_id = L.LOCATION_ID
   AND E.job_id = J.job_id;
   
   