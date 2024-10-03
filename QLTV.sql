use library_management;

GO
CREATE TABLE QLSach (
    MaSachID INT PRIMARY KEY auto_increment,
    TenSach VARCHAR(255),       
    NamXB INT,                    
    TheLoai VARCHAR(100),         
    TacGia VARCHAR(255)           
);

GO
create table User (
	username varchar(50) primary key,
    password varchar(50)
); 

create table student(
	StudentID int primary key auto_increment,
    StudentName varchar(255),
    StudentLocation varchar(255),
    StudentSDT int,
    StudentGmail varchar(255)
);

GO
select* from student;