package com.harman.project;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {

        try {


            Connection c = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/college?autoReconnect=true&useSSL=false", "root", "");
            // This for the connection with database with this code !!!

            Scanner inp = new Scanner(System.in);

            String name, rollnum, admnnum, college;
            System.out.println("Enter the Name:  ");
            name = inp.next();
            System.out.println("Enter the Roll Number:  ");
            rollnum = inp.next();
            System.out.println("Enter the Admission Number:  ");
            admnnum = inp.next();
            System.out.println("Enter the College Name:  ");
            college = inp.next();

            Statement stmt = c.createStatement();

            stmt.executeUpdate("INSERT INTO `student`(`name`, `rollnum`, `admnnum`, `college`) " +
                    "VALUES('"+name+"', "+rollnum+", "+admnnum+", '"+college+"')");
            System.out.println("Table Inserted Successfully");
        }

        catch (SQLException e)
        {
            System.out.println(e);
        }
    }
}
