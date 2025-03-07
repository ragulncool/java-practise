#using group_by
SELECT 
    marks, subject,
    COUNT(marks)
FROM 
    MARKS
GROUP BY                
    marks,subject      #if more than two, combination of both columns
#HAVING 
    #COUNT(marks) > 1;
    #column used in select should be in group by else below error
    #Error Code: 1055. Expression #2 of SELECT list is not in GROUP BY clause and contains nonaggregated column 'college.MARKS.subject' which is not functionally dependent on columns in GROUP BY clause; this is incompatible with sql_mode=only_full_group_by



#select or delete duplicates based on single column

SELECT marks, COUNT(marks)
FROM MARKS
GROUP BY
	marks
HAVING COUNT(marks)>1

#select unique. rows
#NOT WORKING
SELECT * FROM MARKS WHERE ID NOT IN(
SELECT id
FROM MARKS
GROUP BY
	marks
HAVING COUNT(marks)>1
)
