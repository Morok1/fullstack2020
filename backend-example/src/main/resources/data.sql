CREATE TABLE course
(
    id          int         not null primary key,
    username    varchar(50) NOT NULL,
    description varchar(50) NOT NULL
);

CREATE TABLE student
(
    id       int         not null primary key,
    username varchar(50) NOT NULL
);

CREATE TABLE student_courses
(
    id         bigint(20) primary key AUTO_INCREMENT,
    course_id  bigint(20) NOT NULL,
    student_id bigint(20) NOT NULL,
    FOREIGN KEY (student_id) references student (id),
    FOREIGN KEY (course_id) references course (id)
);

INSERT INTO course (id, username, description)
VALUES (1, 'C++', 'C++');
INSERT INTO course (id, username)
VALUES (2, 'Java', 'Java');
INSERT INTO student
VALUES (1, 'Peter');
INSERT INTO student_courses (id, course_id, student_id)
VALUES (1, 1, 1);

