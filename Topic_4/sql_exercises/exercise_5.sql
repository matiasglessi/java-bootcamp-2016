-- For a given teacher, list the timeline for each course that he is assigned to (ordered by date), 
-- and the course name. The format should be:

-- Teacher: <last-name>, <first-name>
-- Schedule:
--   Monday 09:00 - 11:00: <course-name>
--   Monday 15:00 - 17:30: <course-name>
--   Friday 08:45 - 10:40: <course-name>

-- Replace <given-teacher-name> for actual course name. E.g 'Rodriguez'.

SELECT CONCAT(teacher.last_name, ', ',teacher.first_name) AS 'Teacher',	
	   CONCAT(DAYNAME(course.start_date),' ' ,DATE_FORMAT(course.start_date, '%H:%i'), ' - ', DATE_FORMAT(course.end_date, '%H:%i')) AS 'Schedule',
	   course.name AS 'Course'
FROM course, teacher
WHERE (course.teacher_name = teacher.last_name) AND (teacher.last_name = '<given-teacher-name>')
ORDER BY DAYNAME(course.start_date);