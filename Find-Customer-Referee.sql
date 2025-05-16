/* Write your PL/SQL query statement below */
select name
from Customer
where referee_id NOT IN(select referee_id
from Customer where referee_id=2) OR referee_id IS NULL;