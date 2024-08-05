CREATE DATABASE IF NOT EXISTS emp;
USE emp;
create database CompanyDb;
Use CompanyDb;
CREATE TABLE Emp (
    ENo INT PRIMARY KEY,
    EName VARCHAR(100),
    salary DECIMAL(10, 2),
    Desg VARCHAR(50)
);
select * from Emp;
