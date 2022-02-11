# Join exercise

1. Create and populate datebase

```
/* Setup database */
create database mydb;
use mydb;

/* Start clean */
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS departments;

/* Recreate "departments" table */
CREATE TABLE departments ( 
    department_id int(11) NOT NULL AUTO_INCREMENT, 
    dname varchar(255) NOT NULL,  
    PRIMARY KEY  (department_id)
) ENGINE=InnoDB;
 
 
/* Recreate "employees" table, Each employee belongs to a department */ 
CREATE TABLE employees (  
    employee_id int(11) NOT NULL AUTO_INCREMENT, 
    ename varchar(255) NOT NULL, 
    department_id int(11) default NULL,
    salary decimal(7,2) NOT NULL,  
    PRIMARY KEY  (employee_id),
    FOREIGN KEY (department_id) REFERENCES departments(department_id)
) ENGINE=InnoDB;  

/* Data for the table departments */
INSERT INTO departments(department_id, dname)
VALUES
(1,'Engineering'),      
(2,'Sales'),     
(3,'Marketing'),
(4,'HR');

/* Data for the table employees */
INSERT INTO employees(employee_id, ename, salary, department_id)
VALUES
(1,'jack','3000.00', 1),
(2,'mary','2500.00', 2),
(3,'nichole','4000.00', 1),
(4,'angie','5000.00', 2),
(5,'jones','5000.00', 3),
(6,'newperson','5000.00', NULL);
```

2. Do "cross join"

```
/* The following two Cross Join statements are equivalent */

/* Cross Join Option #1 */
SELECT 'Cross Join', e.ename, e.salary, d.dname
FROM employees AS e, departments AS d;

/* Cross Join Option #2 */
SELECT 'Cross Join', e.ename, e.salary, d.dname
FROM employees AS e CROSS JOIN departments AS d;
```

3. Do "Inner join"

```
/* The following Inner Join statements are equivalent */

/* Inner Join Option #1 */
SELECT 'Inner Join', employees.ename, employees.salary, departments.dname
FROM employees, departments
WHERE employees.department_id=departments.department_id;

/* Inner Join Option #2 */
SELECT 'Inner Join', employees.ename, employees.salary, departments.dname
FROM employees
JOIN departments
WHERE employees.department_id=departments.department_id;

/* Inner Join Option #3 */
SELECT 'Inner Join', employees.ename, employees.salary, departments.dname
FROM employees
INNER JOIN departments
WHERE employees.department_id=departments.department_id;

/* Inner Join Option #4 */
SELECT 'Inner Join', employees.ename, employees.salary, departments.dname
FROM employees
INNER JOIN departments
ON employees.department_id=departments.department_id;
```

4. Do "Outer Join"

```
/* Outer Join could be either LEFT JOIN or RIGHT JOIN */

/* Outer Join #1 - LEFT JOIN */
/* All records (actually fields of the records) of the "employees" table
 * are included in the result set because the "employees" table is
 *  left side of the JOIN */
SELECT 'Outer Join - LEFT JOIN ', employees.ename, employees.salary, departments.dname
FROM employees
LEFT JOIN departments
ON employees.department_id=departments.department_id;

/* Outer Join #2 - RIGHT JOIN */
/* All records (actually fields of the records) of the "departments" table
 * are included in the result set because the "departments" table is
 * right side of the JOIN */
SELECT 'Outer Join - RIGHT JOIN', employees.ename, employees.salary, departments.dname
FROM employees
RIGHT JOIN departments
ON employees.department_id=departments.department_id;

/* Outer Join #3- RIGHT JOIN, Same result as Outer Join #1
 * because the tables are switched but using RIGHT JOIN
 * instead of LEFT JOIN */
SELECT 'Outer Join - LEFT JOIN ', employees.ename, employees.salary, departments.dname
FROM departments
RIGHT JOIN employees
ON employees.department_id=departments.department_id;

/* Outer Join #4 - LEFT JOIN, Same result as Outer Join #2
 * because the tables are switched but using LEFT JOIN
 * instead of RIGHT JOIN */
SELECT 'Outer Join - RIGHT JOIN', employees.ename, employees.salary, departments.dname
FROM departments
LEFT JOIN employees
ON employees.department_id=departments.department_id;

/* Outer Join #5 - Same result as #3 but using optional OUTER keyword */
SELECT 'Outer Join - LEFT JOIN ', employees.ename, employees.salary, departments.dname
FROM departments
RIGHT OUTER JOIN employees
ON employees.department_id=departments.department_id;

/* Outer Join #6 - Same result as #4 but using optional OUTER keyword */
SELECT 'Outer Join - RIGHT JOIN', employees.ename, employees.salary, departments.dname
FROM departments
LEFT OUTER JOIN employees
ON employees.department_id=departments.department_id;
```

5. Self join

```
/* Self Join involves joining a table to itself */

/* Self Join */
SELECT 'Self Join', e1.ename, e2.salary
FROM employees AS e1, employees AS e2
WHERE e1.employee_id=e2.employee_id;
```