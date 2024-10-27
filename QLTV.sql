create database library_management;

use library_management;

CREATE TABLE QLSach (
    MaSachID varchar(50) PRIMARY KEY,
    TenSach VARCHAR(255),       
    NamXB INT,                    
    TheLoai VARCHAR(100),         
    TacGia VARCHAR(255),
    SoLuong int
);

create table User (
	username varchar(50) primary key,
    password varchar(50)
); 

create table student(
	StudentID varchar(50) primary key ,
    StudentName varchar(255),
    StudentLocation varchar(255),
    StudentSDT int,
    StudentGmail varchar(255)
);

create table LibrarianManager(
	LibrarianID int primary key,
	nameLibrarian varchar(250),
    employeeCard varchar(50)
);


CREATE TABLE LibrarianLogin (
    username VARCHAR(50),
    password VARCHAR(50),
    LibrarianID INT primary key,
    CONSTRAINT fk_librarian FOREIGN KEY (LibrarianID) 
    REFERENCES LibrarianManager(LibrarianID)
    ON DELETE CASCADE 
    ON UPDATE CASCADE
);

create table LibrarianAcept(
	StudentID varchar(50),
    MaSachID varchar(50),
    SoLuong int,
    ChoMuon varchar(150)
);

create table Transaction(
	StudentID varchar(100),
    BookID varchar(100),
    Amount int,
	NgayMuon DATE,
    NgayTra DATE,
    Status varchar(100)
);

select * from Transaction;
select * from LibrarianAcept;
select * from LibrarianLogin;
select* from QLSach;
select * from student;
select * from LibrarianManager;
select * from User;
select * from LibrarianLogin;