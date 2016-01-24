CREATE DATABASE  IF NOT EXISTS `high-school`;
USE `high-school`;

CREATE TABLE Student(
	reg_number INTEGER NOT NULL, 
	first_name VARCHAR(40) NOT NULL,
	last_name VARCHAR(40) NOT NULL,
	date_of_birth DATE NOT NULL,
	CONSTRAINT Pk_Student PRIMARY KEY (reg_number));

CREATE TABLE Teacher(
	first_name VARCHAR(40) NOT NULL,
	last_name VARCHAR(40) NOT NULL,
	date_of_birth DATE NOT NULL,
	CONSTRAINT Pk_Teacher PRIMARY KEY (last_name));


CREATE TABLE Course(
	id INTEGER NOT NULL;
	name VARCHAR(40) NOT NULL,
	teacher_name VARCHAR(40) NOT NULL,
	hours_by_week INTEGER NOT NULL,
	start_date DATETIME NOT NULL,
	end_date DATETIME NOT NULL,
	CONSTRAINT Pk_Course PRIMARY KEY (id),
	CONSTRAINT Fk_Course_Teacher 
		FOREIGN KEY (teacher_name) REFERENCES Teacher (last_name));


CREATE TABLE Assist_to(
	student_reg_number INTEGER NOT NULL, 
	course_id INTEGER NOT NULL,
	parcial_note1 INTEGER,
	parcial_note2 INTEGER,
	parcial_note3 INTEGER,
	final_note INTEGER,
	CONSTRAINT Pk_Assist_to PRIMARY KEY (student_reg_number,course_id),
	CONSTRAINT Fk_Assist_to_Student 
		FOREIGN KEY (student_reg_number) REFERENCES Student (reg_number),
	CONSTRAINT Fk_Assist_to_Course 
		FOREIGN	KEY (course_id) REFERENCES Course (id));