# Java_Menu_DrivenApp

This repository contains a Java program that performs various database operations using JDBC. The application provides a menu-driven interface to manage employee records in a MySQL database. It supports the following operations:
- Inserting records into the database
- Updating existing records
- Deleting records
- Searching for records by employee number
- Displaying all records

## Features

1. **Insert Into Database**: Add new employee records to the database.
2. **Update Database**: Update details of existing employee records.
3. **Delete From Database**: Remove employee records from the database.
4. **Search By Emp Number**: Retrieve details of an employee by their employee number.
5. **Show All Records**: Display all employee records in the database.

## Requirements

- Java Development Kit (JDK) 8 or later
- MySQL Database
- MySQL JDBC Driver
- SQL Script Is provided within the repo.
- Driver For Mysql JDBC is also provided.

## Steps to Run

1. **Clone the Repository**: Download the project to your local machine.
    ```bash
    git clone https://github.com/yourusername/JDBCEmployeeManagement.git
    cd JDBCEmployeeManagement
    ```

2. **Configure Database Connection**: Update the database connection details in the `MenuAssignment` class.
    ```java
    private static String DBurl = "jdbc:mysql://localhost:3306/DATABASE NAME";
    private static String username = "root"; //Your Own UName and Pass
    private static String password = "root";
    ```

3. **Compile the Program**: Compile the Java files using a Java compiler.
    ```bash
    javac Menu_Driven_Application.java
    ```

4. **Run the Program**: Execute the compiled Java program.
    ```bash
    java Menu_Driven_Application.java
    ```

5. **Interact with the Menu**: Use the menu options to perform various database operations.

## Notes

- Ensure your MySQL database is running and accessible.
- Make sure the `Emp` table exists in the `CompanyDb` database with the appropriate schema.
- Include the MySQL JDBC driver in your classpath if it's not already available.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
