-- CREATE DATABASE `test1` CHARACTER SET utf8 COLLATE utf8_general_ci;
-- DROP DATABASE `test1`;
use test1;
CREATE TABLE recordtest(
id varchar(123),
clname varchar(123)
);

-- DROP TABLE recordtest; 
-- TRUNCATE TABLE recordtest; xoa du lieu co trong table, ko xoa table


-- ALTER TABLE recordtest
-- DROP COLUMN age1;
-- ALTER TABLE recordtest
-- ADD PRIMARY KEY (id);
-- ALTER TABLE recordtest
-- ADD CHECK(age > 100);
UPDATE user SET pass = '123456' WHERE ID = 8;
ALTER TABLE recordtest
ALTER age SET DEFAULT 18;
DELETE FROM user WHERE id = 2;
SELECT * FROM test1.recordtest WHERE clname NOT IN ("van","taa");
ALTER TABLE recordtest AUTO_INCREMENT=100 ;
INSERT INTO recordtest (clname) VALUE ("taaa1");
ALTER TABLE recordtest
MODIFY COLUMN id INT NOT NULL AUTO_INCREMENT;
Describe recordtest;