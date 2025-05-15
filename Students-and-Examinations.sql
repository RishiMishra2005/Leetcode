# Write your MySQL query statement below
select A.student_id, A.student_name, C.subject_name, count(B.subject_name) as attended_exams
from Students as A
cross join Subjects as C
left join Examinations as B
on A.student_id = B.student_id and C.subject_name = B.subject_name
group by A.student_id, A.student_name, C.subject_name
order by A.student_id, C.subject_name;