CREATE TABLE `dept03` (
	`deptno` INT(11) NOT NULL AUTO_INCREMENT,
	`dname` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	`loc` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_general_ci',
	PRIMARY KEY (`deptno`) USING BTREE
)
COLLATE='utf8_general_ci'
;