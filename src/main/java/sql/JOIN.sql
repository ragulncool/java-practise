CREATE DATABASE OFFICE
#DROP DATABASE OFFICE
USE OFFICE

CREATE TABLE EMPLOYEES(empId INTEGER(5), empName VARCHAR(10), empCity VARCHAR(10));
ALTER TABLE EMPLOYEES ADD (manId INTEGER(5), PRIMARY KEY (empId));

INSERT INTO EMPLOYEES VALUES(1,'one','COIMBATORE',11);
INSERT INTO EMPLOYEES VALUES(2,'two','CHENNAI',12);

CREATE TABLE MANAGERS(manId INTEGER(5), manName VARCHAR(10), manCity VARCHAR(10), PRIMARY KEY (manId));
INSERT INTO MANAGERS VALUES(11,'three','COIMBATORE');
INSERT INTO MANAGERS VALUES(12,'four','CHENNAI');

--IF EMPLOYEES AND MANAGERS ARE DIFF TABLE
--We are using LEFT OUTER JOIN bcause we don’t want to skip employees that doesn’t have manager
SELECT e.empId, e.empName, m.manId, m.manName from EMPLOYEES as e LEFT OUTER JOIN MANAGERS as m ON e.manId=m.manId --WRONGLY USED WHERE INSTEAD OF ON

INSERT INTO EMPLOYEES VALUES(11,'one','COIMBATORE',null);
INSERT INTO EMPLOYEES VALUES(12,'two','CHENNAI',null);

--MANAGERS ARE PART OF EMPLOYEE TABLE
SELECT e.empId, e.empName, m.empId, m.empName from EMPLOYEES as e LEFT OUTER JOIN EMPLOYEES as m ON e.manId=m.manId

------------------------------

--EMPLOYEES FROM CITY
SELECT empCity, count(empCity) from EMPLOYEES GROUP BY empCity

--EMPLOYEES UNDER MANAGER
SELECT m.manId, count(m.manId) FROM MANAGERS AS m LEFT OUTER JOIN EMPLOYEES AS e ON m.manId=e.manId GROUP BY m.manId

--EMPLOYEES FROM SAME CITY
--EXAMPLE: DELETE DUPLICATES BASE ON KEY - EMPLOYEES WITH SAME EMAIL
--WAY 1
SELECT e1.empId, e1.empName, e1.empCity FROM EMPLOYEES e1, EMPLOYEES e2 WHERE e1.empCity=e2.empCity and e1.empId != e2.empId 



--USER DEFINED FUNCTION - accept param, process and return result  //NOT WORKING

CREATE FUNCTION GetEmployee(@empId INTEGER)  
 RETURNS VARCHAR(50)  
 AS  
BEGIN  
    RETURN (SELECT empName FROM EMPLOYEES WHERE empId=@empId)  
END 

PRINT dbo.GetEmployee(1)  //Print name of the employee

--STORED PROCEDURE //not working

CREATE PROCEDURE join_employees
AS
SELECT e1.empId, e1.empName, e1.empCity FROM EMPLOYEES e1, EMPLOYEES e2 WHERE e1.empCity=e2.empCity and e1.empId != e2.empId GO;

EXEC join_employees;


--WHERE VS HAVING

SELECT empId from EMPLOYEES where empId<10
SELECT empId from EMPLOYEES HAVING empId<10


#WHERE - Aprt from select, we can use for update and delete query
#HAVING - We can use for select only

WHERE - Used before group by. Can be used without group by.
First rows are filtered and only the filtered rows are grouped [PRE FILTER]

HAVING - Used after group by. WHen using Group by, having is must and not the inverse
First rows are grouped and then filtered [ POST FILTER]

#Cannot contain aggregate func (avg, sum)
#CAN CONTAIN





