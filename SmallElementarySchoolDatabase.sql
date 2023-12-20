-- Create a database
CREATE DATABASE ElementarySchoolDB;
USE ElementarySchoolDB;

-- Create a table for students
CREATE TABLE Students (
    StudentID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    BirthDate DATE,
    GradeLevel INT,
    TeacherID INT,
    MarkingPeriod1Grade INT,
    MarkingPeriod2Grade INT,
    MarkingPeriod3Grade INT,
    MarkingPeriod4Grade INT,
    FOREIGN KEY (TeacherID) REFERENCES Teachers(TeacherID)
);

-- Create a table for teachers
CREATE TABLE Teachers (
    TeacherID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    HireDate DATE,
    RoomNumber INT
);



