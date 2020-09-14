CREATE TABLE `emp03` (
	`empno` INT(11) NOT NULL AUTO_INCREMENT,
	`ename` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
	`sal` INT(11) NOT NULL DEFAULT '0',
	`hiredate` TIMESTAMP NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
	`deptno` INT(11) NOT NULL DEFAULT '0',
	PRIMARY KEY (`empno`) USING BTREE,
	INDEX `FK_emp03_dept03` (`deptno`) USING BTREE,
	CONSTRAINT `FK_emp03_dept03` FOREIGN KEY (`deptno`) REFERENCES `xe`.`dept03` (`deptno`) ON UPDATE NO ACTION ON DELETE NO ACTION
)
COLLATE='utf8_general_ci'
;
