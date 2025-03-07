CREATE DATABASE COLLEGE;
#DROP DATABASE COLLEGE

USE COLLEGE;



CREATE TABLE STUDENT(studId INTEGER(5) not NULL, 
 name VARCHAR(255) UNIQUE,  city VARCHAR(255),  age INTEGER,  PRIMARY KEY (studId));
 --PRIMARY CANNOT CONTAIN NULL BUT UNIQUE CAN CONTAIN NULL
 --ONLY ONE PK FOR DB BUT ANY NUMBER OF COLUMNS AS UNIQUE
 
 INSERT INTO STUDENT VALUES (100, 'Zara1', 'Ali', 18);
 INSERT INTO STUDENT VALUES (101, 'Zara2', 'Ali', 18);
 INSERT INTO STUDENT VALUES (102, 'Zara3', 'Ali', 18);
 
 UPDATE STUDENT
        SET age = 30
                WHERE studId=101;
 
 #DROP TABLE STUDENT #table structure and constraints will be dropped
#TRUNCATE  TABLE STUDENT

 #DELETE  FROM STUDENT
#DELETE  FROM STUDENT WHERE ID=102

CREATE TABLE MARKS(id INTEGER(5) not NULL, 
subject VARCHAR(10),  marks INTEGER(5),  studId INTEGER(5),  PRIMARY KEY (id));

INSERT INTO MARKS VALUES (1, 'English', 50, 101);
INSERT INTO MARKS VALUES (2, 'English', 50, 102);
 INSERT INTO MARKS VALUES (3, 'English', 44, 103);
 INSERT INTO MARKS VALUES (4, 'Tamil', 55, 101);
 INSERT INTO MARKS VALUES (8, 'Maths', 60, 101);
  INSERT INTO MARKS VALUES (6, 'Science', 70, 101);
   INSERT INTO MARKS VALUES (7, null, 80, 101);
    #DROP TABLE MARKS
 
 
 -- TYPES OF SELECT
 SELECT * FROM STUDENT
 SELECT * FROM MARKS
 SELECT * FROM MARKS WHERE subject IS NULL
SELECT * FROM MARKS WHERE marks =60.              --SINGLE EXACT MATCH
SELECT * FROM MARKS WHERE marks IN (60, 80)       --GET SET OF VALUES - MULTI EXACT MATCH
SELECT * FROM MARKS WHERE marks BETWEEN 60 and 80 --RANGE OF VALUES

#SELECT TOP 2 * FROM MARKS                        --LIMIT
SELECT * FROM MARKS LIMIT 2; 
#SELECT * FROM MARKS WHERE ROWNUM <= 2;

--WILDCARDS

SELECT * FROM MARKS WHERE subject LIKE '%ng%'     --PARTIAL MATCHING % MEANS ONE OR MORE CHAR
SELECT * FROM MARKS WHERE subject LIKE '%nglis_'  -- _MEANS SINGLE CHAR


 --UNION , UNION ALL
 --EXAMPLE LIST IDS FROM BOTH TABLE, CUSTOMERS FROM BOTH BUSINESS
 SELECT name FROM STUDENT UNION SELECT subject FROM MARKS #prints both in single row omitting duplicates
  SELECT name FROM STUDENT UNION ALL SELECT subject FROM MARKS #includes duplicates
    SELECT studId FROM STUDENT INTERSECT SELECT studId FROM MARKS #print columns values common in both tables
       # SELECT studId FROM STUDENT MINUS SELECT studId FROM MARKS #print columns not common in both (opposite of intersect)


  
  #both side should have same column count, both will be combined in one column
   SELECT name, studId FROM STUDENT UNION SELECT subject, id FROM MARKS #prints both in single row omitting duplicates


#Error Code: 1055. Expression #2 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'college.MARKS.subject' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by

--AGGREGATE FUNCTIONS

SELECT MIN(marks), MAX(marks), AVG(marks), count(marks), SUM(marks) from MARKS

--SUBQUERY

SELECT id
FROM MARKS
WHERE marks > (SELECT AVG(marks) FROM MARKS);

--A composite primary key 
is a primary key made up of two or more columns. Together, these columns must form a unique combination for each row in the table. It’s used when a single column isn’t sufficient to uniquely identify a record.

--query to retrieve employees who earn more than the average salary.
SELECT * FROM MARKS WHERE MARKS > (select AVG(MARKS) FROM MARKS)

--FIND COUNT OF DUPLICATE RECORDS
SELECT city, COUNT(city) FROM STUDENT GROUP BY city


--DELETE DUPLICATE RECORDS FROM TABLE (BASED ON EMP ID)
SELECT * FROM STUDENT WHERE studId IN (SELECT MIN(studId) from STUDENT)

--query to fetch common records from two tables.
SELECT *
FROM TableA
INNER JOIN TableB ON TableA.ID = TableB.ID;

--query to find employees whose salaries are higher than their managers.
SELECT e.EmployeeID, e.Salary
FROM Employee e
JOIN Employee m ON e.ManagerID = m.EmployeeID
WHERE e.Salary > m.Salary;

--query to find departments with the highest average salary. (CONFUSING)
SELECT DepartmentID
FROM Employee
GROUP BY DepartmentID
ORDER BY AVG(Salary) DESC
LIMIT 1;