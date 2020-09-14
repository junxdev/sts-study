CREATE TABLE dept(
deptno NUMBER PRIMARY KEY, dname VARCHAR(255), loc VARCHAR(255));
INSERT INTO dept VALUES(10, '회계', '서울');
INSERT INTO dept VALUES(20, '영업', '서울');
INSERT INTO dept VALUES(30, '생산', '파주');
COMMIT;
SELECT * FROM dept;