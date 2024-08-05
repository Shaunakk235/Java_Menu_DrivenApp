//TABLE NAME IS -- "Emp" --MAKE SURE TO REPLACE IT WITH YOUR TABLE NAME...!


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Menu_Driven_Application {

    private static String DBurl = "jdbc:mysql://localhost:3306/DATABASE NAME";// Enter Your Database Name Here
    private static String username = "root"; //Change Password And Username Accordingly
    private static String password = "root";
    private static Connection con;

    public static void main(String[] args) throws Exception {
        con = DriverManager.getConnection(DBurl, username, password);
        System.out.println("Connection Successful");

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("---Select Your Operation---");
            System.out.println("1 .Insert Into Database");
            System.out.println("2 .Update Database");
            System.out.println("3 .Delete From Database");
            System.out.println("4 .Search By Emp Number");
            System.out.println("5 .Show All Records");
            System.out.println("6 .Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertRecord();
                    break;
                case 2:
                    updateRecords();
                    break;
                case 3:
                    deleteRecords();
                    break;
                case 4:
                    searchRecords();
                    break;
                case 5:
                    showRecords();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Option Selected");
            }
        } while (choice != 6);
    }

    private static void showRecords() throws Exception {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Emp");

        while (rs.next()) {
            int ENo = rs.getInt("ENo");
            String EName = rs.getString("EName");
            int salary = rs.getInt("salary");
            String Desg = rs.getString("Desg");
            System.out.println(ENo + " " + EName + " " + salary + " " + Desg);
        }
    }

    private static void searchRecords() throws Exception {
        System.out.println("Enter Employee Id To Search");
        Scanner sc = new Scanner(System.in);
        int ENo = sc.nextInt();

        String sql = "SELECT * FROM Emp WHERE ENo = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, ENo);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            String EName = rs.getString("EName");
            int salary = rs.getInt("salary");
            String Desg = rs.getString("Desg");
            System.out.println(ENo + " " + EName + " " + salary + " " + Desg);
        } else {
            System.out.println("Record not found.");
        }
    }

    private static void deleteRecords() throws Exception {
        System.out.println("Enter Employee Id To Delete");
        Scanner sc = new Scanner(System.in);
        int ENo = sc.nextInt();

        String sql = "DELETE FROM Emp WHERE ENo = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, ENo);
        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Record deleted successfully");
        } else {
            System.out.println("Record not found.");
        }
    }

    private static void updateRecords() throws Exception {
        System.out.println("Enter Employee Id To Update");
        Scanner sc = new Scanner(System.in);
        int ENo = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter New Employee Name");
        String EName = sc.nextLine();
        System.out.println("Enter New Salary");
        int salary = sc.nextInt();
        sc.nextLine(); 
        System.out.println("Enter New Designation");
        String Desg = sc.nextLine();

        String sql = "UPDATE Emp SET EName = ?, salary = ?, Desg = ? WHERE ENo = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, EName);
        pst.setInt(2, salary);
        pst.setString(3, Desg);
        pst.setInt(4, ENo);
        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            System.out.println("Record updated successfully");
        } else {
            System.out.println("Record not found.");
        }
    }

    // ENo, EName, salary, Desg
    private static void insertRecord() throws Exception {
        System.out.println("Enter Details Like Emp num, Emp Name, Salary, Designation");
        Scanner sc = new Scanner(System.in);
        int ENo = sc.nextInt();
        sc.nextLine();
        String EName = sc.nextLine();
        int salary = sc.nextInt();
        sc.nextLine(); 
        String Desg = sc.nextLine();

        String sql = "INSERT INTO Emp (ENo, EName, salary, Desg) VALUES (?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, ENo);
        pst.setString(2, EName);
        pst.setInt(3, salary);
        pst.setString(4, Desg);
        pst.executeUpdate();
        System.out.println("Record inserted successfully");
    }
}
