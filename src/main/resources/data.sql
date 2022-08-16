DROP TABLE IF EXISTS COURSE;

DROP TABLE IF EXISTS PERSON;

CREATE TABLE PERSON (
    personId int,
    firstName varchar(50),
    lastName varchar(50),
    email varchar(150),
    phoneNumber varchar(20)
);

DROP TABLE IF EXISTS COURSE;

CREATE TABLE COURSE (
    courseId int,
    courseName varchar(255),
    courseCategory varchar(100),
    courseLevel varchar(100),
    city varchar(100),
    personId int 
);

INSERT INTO PERSON (personId,firstName,lastName, email,phoneNumber ) VALUES (1,'Pedro', 'Alberto', 'Pedro@gmail.com', '+55(21)99999-7777');
INSERT INTO PERSON (personId,firstName,lastName, email,phoneNumber ) VALUES (2,'Carlos', 'Souza', 'Carlos@gmail.com', '+55(11)22222-7777');
INSERT INTO PERSON (personId,firstName,lastName, email,phoneNumber ) VALUES (3,'Agner', 'Fabio', 'Agner@gmail.com', '(212)456-7890');

INSERT INTO COURSE (courseId,courseName, courseCategory, courseLevel, city, personId) VALUES (1,'Java Developer', 'I.T', 'Basic', 'Rio de Janeiro',1);
INSERT INTO COURSE (courseId,courseName, courseCategory, courseLevel, city, personId) VALUES (2,'Adobe Premiere Advanced', 'Design', 'Advanced', 'Belo Horizonte',1);
INSERT INTO COURSE (courseId,courseName, courseCategory, courseLevel, city, personId) VALUES (3,'Creating videos', 'Videos', 'Medium', 'Fortaleza',2);