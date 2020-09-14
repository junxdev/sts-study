CREATE TABLE emp(
empno INT PRIMARY KEY AUTO_INCREMENT, 
ename VARCHAR(255), 
job VARCHAR(255), 
sal INT, 
hiredate DATE);

INSERT INTO emp (ename, job, sal, hiredate) VALUES ('박민준', '영업', 2200, now());
INSERT INTO emp (ename, job, sal, hiredate) VALUES ('김서연', '디자이너', 2000, now());
INSERT INTO emp (ename, job, sal, hiredate) VALUES ('오하은', '개발자', 1900, now());

COMMIT;
SELECT * FROM emp;