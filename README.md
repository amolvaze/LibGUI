# LibGUI Project
Library Management System Project :-By Amol Vaze

(a) ->User Instructions For Librarians:- 
This library management system is available for users who are the librarians. All users are required to use this system when they want any book to be checked out.

(b)-> Design Decisions & Justifications :-
Design Decisions:- This library management system application uses simple java swings for the GUI design which includes inbuilt JFrame and WindowsBuilder.

->System Justification & Working:- 
The library system is basically allows user to borrow book for 14 days maximum. The  application has Main GUI window which provides user two options:- 
1.One is to add borrower that means when there is any new member  is added into the system.
2.Second is to search for a particular book which is being checked out for 14 days. Under search option, system allows user to avail check out and check in for a particular book.

->The brief working/functionality  of the system as follows:- 

1. Application starts with main GUI window. If new member is to be added, then system provides separate GUI for taking new member's details. Also, it checks for duplication of first name, last name and address. If member with same first name, last name and address is found, then system gives out message saying that record already exists.

2. When application is required to do checkout or check in process, then it does the following:- 
       a. -> Checkout:- This allows user to check out for a particular book for 14 days.  Thus,  the date on which book is checked out will be the current date. In case of checked out, the system first checks all the necessary conditions and if all are satisfied, then it will allow user to check out. Thus, a new record will be added into the database. 
b. -> CheckIn:-  This allows user to check in a particular book which has been checked out.  In this functionality,  the system first searches particular book and then it will update the corresponding date_in in the database after the book has been returned by the borrower.  
(c) ->Technical Dependencies (software libraries, software versions, etc.):-
1. The software used during implementation of the application is Eclipse JUNO IDE for JAVA for creating various Graphic User Interfaces(GUI) . (jdk Version 1.7.0_51/jre7)
2. Also, it uses  it uses MYSQL Workbench(mysql-5.6.17) for storing data and MYSQL Server for data storage.[ mysql-workbench-community-6.1.4-win32]

 3.For database JDBC connection, it uses mysql-connector-java(Version- 5.1.30)-jar file which has been stored into mysql libraries which is custom created into system.
4. For data import, Python  is used- (Version2.7.6)

[Note:-  For populating data into database, Python is used(populate.py-Script) which reads .CSV files and loads the data into MYSQL database.]
