package com.wipro.jdbc;

import java.sql.*;
import java.util.Scanner;

public class TestEmployee {

    static Connection con_obj;

    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/wipro";;
            String uname = "root";
            String pass = "root";
            con_obj = DriverManager.getConnection(url, uname, pass);
            TestEmployee obj = new TestEmployee();

            Scanner s=new Scanner(System.in);

//            System.out.println("Enter employee details :");
//            System.out.println(" name :");
//            String name=s.next();
//            System.out.println(" salary :");
//            String salary=s.next();
//            System.out.println(" email :");
//            String email=s.next();
//            System.out.println(" address :");
//            String address=s.next();

//            Employee emp = new Employee(name, salary, email, address);
//            obj.addEmployee(emp); ;

            //delete record
//
//            System.out.println("Delete record of one employee from table: ");
//            System.out.println("ID: ");
//            int id = s.nextInt();
//
//            obj.deleteEmployee(id);

            //update record

//            System.out.print("Enter id: ");
//            int uid = s.nextInt();
//            System.out.print("Enter mail to update: ");
//            String EMAIL = s.next();
//            obj.updateEmployee(uid, EMAIL);

            //fetch Retrieve details

            System.out.println("Details of Employees from table\n");
            obj.fetchEmployee();



        }catch(Exception e){
            System.out.println(e);
        }

    }

    void addEmployee(Employee obj)throws SQLException {

        PreparedStatement statement = con_obj.prepareStatement("insert into employee(name, salary, email, address) values (?, ?, ?, ?)");
        statement.setString(1, obj.name);
        statement.setString(2, obj.salary);
        statement.setString(3, obj.email);
        statement.setString(4, obj.address);
        statement.executeUpdate();
        System.out.println("employee is added!");
    }

    void deleteEmployee(int id)throws SQLException{

        PreparedStatement statement = con_obj.prepareStatement("delete from employee where id = "+id);
        statement.executeUpdate();
        System.out.println("Employee is deleted.");

    }
    void updateEmployee(int id, String Email)throws SQLException{

        PreparedStatement statement = con_obj.prepareStatement("update employee set email=? where id=? ");
        statement.setString(1, Email);
        statement.setInt(2, id);

        statement.executeUpdate();
        System.out.println("Employee is updated.");

    }

    void fetchEmployee()throws SQLException {

        ResultSet re = con_obj.createStatement().executeQuery("select * from employee");
        while (re.next()) {
            String name = re.getString("name");
            String Salary = re.getString("salary");
            int ID = re.getInt("id");

            System.out.print(ID+ " : "+ name +" - "+ Salary + "\n");

        }
    }
}
