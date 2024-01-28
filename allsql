Q1.
# Write your MySQL query statement below
select area,population,name
from world
where area>=3000000
union
select area,population,name
from world
where population>=25000000
  
Q2.
  
# Write your MySQL query statement below
update salary
set sex = (case when sex = 'f' then 'm' else 'f'  end);

Q3.
# Write your MySQL query statement below

select * from Cinema
 where id % 2 = 1 and description != 'boring'
 order by rating desc
  
Q4.
  
SELECT DISTINCT P1.Email FROM Person P1,Person P2 

WHERE P1.id <> P2.id AND P1.Email=P2.Email

Q5.

# Write your MySQL query statement below
SELECT P.firstName, P.lastName, A.city, A.state
FROM Person P LEFT JOIN Address A
on P.personId = A.personId

Q6.
SELECT EMP.name AS Employee FROM Employee EMP,Employee MGR
WHERE EMP.managerId=MGR.id AND EMP.salary>MGR.salary

Q7.https://leetcode.com/problems/customers-who-never-order
# Write your MySQL query statement below
SELECT name as Customers
from Customers
where id not in (
    select customerId
    from Orders
);
Q8.
delete p2 from Person p1, Person p2
where p1.Email = p2.Email and p2.id > p1.id;
Q9.
# Write your MySQL query statement below
SELECT w2.id from Weather w1 JOIN Weather w2
ON w2.temperature > w1.temperature AND
datediff(w2.recordDate,w1.recordDate) = 1;

Q10.
# Write your MySQL query statement below
select class from Courses group by class having count(*) >=5;

Q11. 
# Write your MySQL query statement below
select ifnull((select distinct salary 
              from Employee order by 
              salary desc limit 1
              offset 1),null)
              as SecondHighestSalary;
Q12
# Write your MySQL query statement below
SELECT  MAX(SALARY) AS SecondHighestSalary FROM EMPLOYEE WHERE SALARY <>(SELECT MAX(SALARY) FROM EMPLOYEE);

Q13.
# Write your MySQL query statement below
select class from Courses group by class having count(*) >=5;

Q14.select m.name 
from employee as e
inner join employee as m
on e.managerId = m.id
group by e.managerId
having count(e.id)>=5
Q15.
SELECT c.customer_id
FROM Customer c
group by customer_id 
HAVING count(distinct c.product_key) = (select count(distinct p.product_key) FROM Product p);
Q16.
SELECT p.product_id, IFNULL(round(SUM(p.price*u.units)/sum(u.units),2),0) as average_price
FROM Prices p 
LEFT JOIN UnitsSold u
ON p.product_id = u.product_id AND 
u.purchase_date BETWEEN p.Start_date and p.end_date
GROUP BY p.product_id

  
