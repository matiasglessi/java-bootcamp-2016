INSERT INTO Teacher (first_name, last_name, date_of_birth) VALUES ('Maria', 'Gonzalez', '1967-07-02');
INSERT INTO Teacher (first_name, last_name, date_of_birth) VALUES ('Josefina', 'Rodriguez', '1946-11-12');
INSERT INTO Teacher (first_name, last_name, date_of_birth) VALUES ('Albert', 'Einstein', '1971-07-15');

INSERT INTO Course (id, name, teacher_name, hours_by_week, start_date, end_date) VALUES (1, 'TDD', 'Rodriguez', 54, '2016-01-05 19:00:00', '2016-01-05 23:30:00');
INSERT INTO Course (id, name, teacher_name, hours_by_week, start_date, end_date) VALUES (2, 'MySQL', 'Rodriguez', 12, '2016-01-10 08:30:00', '2016-01-10 12:00:00');
INSERT INTO Course (id, name, teacher_name, hours_by_week, start_date, end_date) VALUES (3, 'Spring Core', 'Einstein', 100, '2016-01-19 10:00:00', '2016-01-19 14:55:00');
INSERT INTO Course (id, name, teacher_name, hours_by_week, start_date, end_date) VALUES (4, 'TDD', 'Rodriguez', 20, '2016-01-05 20:00:00', '2016-01-06 00:30:00');

INSERT INTO Student (reg_number, first_name, last_name, date_of_birth) VALUES (1, 'Juan', 'Perez', '2000-06-15');
INSERT INTO Student (reg_number, first_name, last_name, date_of_birth) VALUES (2, 'Luis', 'Fernandez', '1990-03-12');
INSERT INTO Student (reg_number, first_name, last_name, date_of_birth) VALUES (3, 'Pedro', 'Vaca', '1967-05-01');
INSERT INTO Student (reg_number, first_name, last_name, date_of_birth) VALUES (4, 'Nicolas', 'Gutierrez', '1968-02-02');
INSERT INTO Student (reg_number, first_name, last_name, date_of_birth) VALUES (5, 'Lucia', 'Gomez', '1999-09-09');
INSERT INTO Student (reg_number, first_name, last_name, date_of_birth) VALUES (6, 'Carolina', 'Ramundi', '1987-01-19');
INSERT INTO Student (reg_number, first_name, last_name, date_of_birth) VALUES (7, 'Adolfo', 'Garre', '1990-06-15');
INSERT INTO Student (reg_number, first_name, last_name, date_of_birth) VALUES (8, 'Anacleta', 'Basualdo', '1993-06-24');
INSERT INTO Student (reg_number, first_name, last_name, date_of_birth) VALUES (9, 'Roberto', 'Basualdo', '2001-07-04');
INSERT INTO Student (reg_number, first_name, last_name, date_of_birth) VALUES (10, 'Juan Carlos', 'Da Silva', '1998-03-04');
INSERT INTO Student (reg_number, first_name, last_name, date_of_birth) VALUES (11, 'Maximiliano', 'Nolaco', '1984-09-29');
INSERT INTO Student (reg_number, first_name, last_name, date_of_birth) VALUES (12, 'Emiliano', 'Almeida', '1970-05-11');


INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (1, 1, 2, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (2, 1, 5, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (3, 1, 10, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (6, 1, 10, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (7, 1, 9, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (8, 1, 8, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (9, 1, 4, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (10, 1, 4, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (11, 1, 6, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (12, 1, 3, NULL, NULL, NULL);


INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (4, 2, NULL, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (5, 2, NULL, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (6, 2, NULL, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (1, 2, NULL, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (2, 2, NULL, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (3, 2, NULL, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (9, 2, NULL, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (10, 2, NULL, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (11, 2, NULL, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (12, 2, NULL, NULL, NULL, NULL);


INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (3, 3, 3, 6, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (4, 3, 3, 10, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (5, 3, 10, 10, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (1, 3, 8, 1, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (2, 3, 5, 4, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (6, 3, 3, 10, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (10, 3, 3, 3, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (11, 3, 9, 9, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (12, 3, 6, 3, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (8, 3, 7, 7, NULL, NULL);

INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (1, 4, 2, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (2, 4, 5, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (3, 4, 10, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (6, 4, 10, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (7, 4, 9, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (8, 4, 8, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (9, 4, 4, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (10, 4, 4, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (11, 4, 6, NULL, NULL, NULL);
INSERT INTO Assist_to (student_reg_number, course_id, parcial_note1, parcial_note2, parcial_note3, final_note) 
	VALUES (12, 4, 3, NULL, NULL, NULL);
