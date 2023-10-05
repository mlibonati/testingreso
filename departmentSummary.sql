CREATE DATABASE LOYAL;

USE LOYAL;

CREATE TABLE Department (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    LOCATION VARCHAR(255)
);

CREATE TABLE Employee (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    SALARY INT,
    DEPT_ID INT,
    FOREIGN KEY (DEPT_ID) REFERENCES Department(ID)
);

INSERT INTO Department (NAME, LOCATION)
VALUES
    ('Executive', 'Sydney'),
    ('Production', 'Sydney'),
    ('Resources', 'Cape Town'),
    ('Technical', 'Texas'),
    ('Management', 'Paris');
    
INSERT INTO Employee (NAME, SALARY, DEPT_ID)
VALUES
    ('Candice', 4685, 1),
    ('Julia', 2559, 2),
    ('Bob', 4405, 4),
    ('Scarlet', 2350, 1),
    ('Ileana', 1151, 4);
    
SELECT D.NAME AS Departamento, COUNT(E.ID) AS Cantidad_Empleados
FROM DEPARTMENT D
LEFT JOIN EMPLOYEE E ON D.ID = E.DEPT_ID
GROUP BY D.NAME
ORDER BY Cantidad_Empleados DESC, Departamento ASC;