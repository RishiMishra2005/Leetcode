/* Write your PL/SQL query statement below */
select a.name,b.bonus from employee a left join bonus b on a.empid=b.empid where b.bonus<1000  or b.bonus is null