package com.wipro.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            System.out.println("Enter employee details :");
            System.out.println(" name :");
            String name=s.next();
            System.out.println(" salary :");
            String salary=s.next();
            System.out.println(" email :");
            String email=s.next();
            System.out.println(" address :");
            String address=s.next();



            Employee emp = new Employee(name, salary, email, address);
            obj.addEmployee(emp); ;

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


//    void updateEmployee(Employee obj){
//
//    }
//    void deleteEmployee(Employee obj){
//
//    }
//    void fetchEmployee(Employee obj){
//
//    }

}
