CREATE DATABASE baitap1 CHARACTER SET utf8 COLLATE utf8_general_ci;
use baitap1;
CREATE TABLE student(
	id int PRIMARY KEY AUTO_INCREMENT,
    first_name varchar(20) NOT NULL,
    last_name varchar(20) NOT NULL,
    gender varchar(6),
    age int DEFAULT 18,
    telephone varchar(10) CHECK (telephone REGEXP '[0-9]{10}'),
    score int CHECK (score >=0 AND score <=1000)
);
-- ALTER TABLE student
-- ADD  CHECK (gender = "Male" OR gender = "Female");
INSERT INTO student (first_name, last_name, gender, age, telephone, score)
VALUES ('Nguyen', 'Thanh', 'Male', 23, '0987654312', 888);
INSERT INTO student (first_name, last_name, gender, age, telephone, score)
VALUE ("Nguyen", "Cong", "Female", 24, telephone, 888);
INSERT INTO student (first_name, last_name, gender, age, telephone, score)
VALUE ("nike", "Ngoc", "Male", 21, "0987654312", 888);
INSERT INTO student (first_name, last_name, gender, age, telephone, score)
VALUE ("quan", "Hanh", "Female", 22, "0987654312", 888);
INSERT INTO student (first_name, last_name, gender, age, telephone, score)
VALUE ("Nguyen", "nike", "Male", 11, "0987654312", 888);
INSERT INTO student (first_name, last_name, gender, age, telephone, score)
VALUE ("Nguyen", "bill", "Female", 18, telephone, 340);
INSERT INTO student (first_name, last_name, gender, age, telephone, score)
VALUE ("le", "set", "Male", 14, "0987654312", 500);
INSERT INTO student (first_name, last_name, gender, age, telephone, score)
VALUE ("Nguyen", "mop", "Female", 55, "0987654312", 344);
INSERT INTO student (first_name, last_name, gender, age, telephone, score)
VALUE ("trung", "que", "Male", 16, "0987654312", 555);
INSERT INTO student (first_name, last_name, gender, age, telephone, score)
VALUE ("Nguyen", "nike", "Female", 24, telephone, 100);
INSERT INTO student (first_name, last_name, gender, age, telephone, score)
VALUE ("Nguyen", "like", "Male", 55, "0980654312", 888);
INSERT INTO student (first_name, last_name, gender, age, telephone, score)
VALUE ("nike", "trau", "Female", 32, "0187654312", 999);
INSERT INTO student (first_name, last_name, gender, age, telephone, score)
VALUE ("diu", "kem", "Male", 11, telephone, 650);
INSERT INTO student (first_name, last_name, gender, age, telephone, score)
VALUE ("nike", "nhau", "Female", 24, "0787654312", 477);
INSERT INTO student (first_name, last_name, gender, age, telephone, score)
VALUE ("do", "dau", "Male", 56, "0887654312", 551);
INSERT INTO student (first_name, last_name, gender, age, telephone, score)
VALUE ("dao", "nam", "Female", 12, "0487654312", 666);
INSERT INTO student (first_name, last_name, gender, age, telephone, score)
VALUE ("quan", "tran", "Male", 13, "0981654312", 717);
INSERT INTO student (first_name, last_name, gender, age, telephone, score)
VALUE ("nike", "bem", "Female", 23, "0987614312", 656);
INSERT INTO student (first_name, last_name, gender, age, telephone, score)
VALUE ("ngang", "trien", "Male", telephone, 23, 657);
INSERT INTO student (first_name, last_name, gender, age, telephone, score)
VALUE ("ngo", "chieu", "Female", 22, "0987654412", 111);
use baitap1;
SELECT * FROM baitap1.user WHERE name = 'thanh';
DELETE FROM user WHERE id = 1 ;
SELECT COUNT(id) FROM student;
SELECT COUNT(gender) FROM student WHERE gender = 'Male';
SELECT * FROM student WHERE gender = 'Female';
SELECT * FROM student WHERE telephone IS NULL;
SELECT * FROM student WHERE age>=18;
SELECT * FROM student WHERE score > 800;
SELECT * FROM student WHERE score <450;
SELECT * FROM student WHERE last_name = 'nike' OR first_name = 'nike';