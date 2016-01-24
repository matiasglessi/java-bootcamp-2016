-- List students and teachers for a given course. The output format should be:

-- Course: <course-name>
-- Teacher: <last-name>, <first-name>
-- Students:
--  <last-name>, <first-name> (ordered by alphabetically by last name)

-- Replace <given-course-name> for actual course name, e.g 'TDD'.

SELECT course.name AS 'Course: ',  CONCAT(teacher.last_name,', ',teacher.first_name) AS 'Teacher: ',  
		CONCAT(student.last_name,', ',student.first_name) AS 'Student: '
FROM course, teacher, student, assist_to
WHERE (course.teacher_name = teacher.last_name) AND (student.reg_number = assist_to.student_reg_number)
		AND (course.name = assist_to.course_name) AND (course.name = '<given-course-name>')
ORDER BY student.last_name;
