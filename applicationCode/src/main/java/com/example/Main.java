package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;


public class Main {

    //allows the connection to be accessed anywhere in the class
    static Connection connection;

    public static void main(String[] args) {
    //to access postgre
    String url = "jdbc:postgresql://localhost:5432/student";

    //username
    String user = "postgres";

    //password
    String password="postgressql";
   



    try{

     Class.forName("org.postgresql.Driver");


     //establishes connection
    connection = DriverManager.getConnection(url, user, password);

    //ensures connection is established 
    if(connection!=null){
        System.out.println("Connected to the database");
    }else{
        System.out.println("Failed to connect to the database");
    }


    //testing functions 
    getAllStudents();

    //test adding students
    // addStudent("Zenadaya", "Coleman", "ZC@gmail.com", Date.valueOf("2022-03-01"));
    // addStudent("Tom", "Holland", "TomH@gmail.com", Date.valueOf("2023-04-03"));


    // getAllStudents();

    //test update emails
    // updateStudentEmail(4, "ZendayaC@gmail.com");

    // getAllStudents();

    //error checking
    // updateStudentEmail(7, "dontExist@gmail.com");
    // getAllStudents();

    //test deletion
    // deleteStudent(4);
    // getAllStudents();

    // deleteStudent(5);
    // getAllStudents();

    //error checking 
    // deleteStudent(5);
     // getAllStudents();

     connection.close();

    }

    catch(Exception e){
        e.printStackTrace();
    }
    }








    public static void getAllStudents(){

        try{

        //create a statment and execute the desired query
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Students");


        //output the results one by one
        while (resultSet.next())
        {
            System.out.println("Student id: " + resultSet.getInt("student_id"));
            System.out.println("Student first name: " + resultSet.getString("first_name"));
            System.out.println("Student last name: " + resultSet.getString("last_name"));
            System.out.println("Student email: " + resultSet.getString("email"));
            System.out.println("Student enrollment date: " + resultSet.getDate("enrollment_date"));
            System.out.println();
        }
    
        statement.close();
        resultSet.close();
        //catch sql exceptions

} catch (SQLException e) {
    System.out.println("Connection failed. Check output console.");
    e.printStackTrace();
}

    }

    


    public static void addStudent(String first_name, String last_name, String email, Date enrollment_date){

        try{
//sql query
    String sqlstmt = "INSERT INTO Students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";
    
    //use a prepared statement for better safety
    PreparedStatement preparedStatement = connection.prepareStatement(sqlstmt);
    //set the parameters
    preparedStatement.setString(1, first_name);
    preparedStatement.setString(2, last_name);
    preparedStatement.setString(3, email);
    preparedStatement.setDate(4, enrollment_date);
    
    //execute the update 
    int inserted = preparedStatement.executeUpdate();


            //ensure a student was added and output a success message 
            if (inserted>0)
            {
                System.out.println("A new student was added!");
            }
        
            preparedStatement.close();
            //catch sql exceptions
    } catch (SQLException e) {
        System.out.println("Connection failed. Check output console.");
        e.printStackTrace();
    }
    }
    
    
    public static void updateStudentEmail(int student_id, String new_email){
        try{

            //create statement and write sql statment using parameters 
            Statement statement = connection.createStatement();
            int updated = statement.executeUpdate("UPDATE Students SET email = '" 
            + new_email + "' WHERE student_id = " 
            + student_id);


            //check the success of the operation 
            if (updated > 0) {
                System.out.println("A student's email was updated!");
            } else {
                System.out.println("No student with ID " + student_id + " found or no changes made.");
            }
        
            statement.close();
    
            //catch sql exceptions
    } catch (SQLException e) {
        System.out.println("Connection failed. Check output console.");
        e.printStackTrace();
    }
    }
    



    public static void deleteStudent(int student_id){

        try{
            //create a statement and write the sql statement with the parameters 
            Statement statement = connection.createStatement();
            int deleted = statement.executeUpdate("DELETE FROM Students WHERE student_id = " 
            + student_id);

            //check the success of the operation
            if (deleted > 0) {
                System.out.println("A student was deleted!");
            } else {
                System.out.println("No student with ID " + student_id + " found.");
            }
        
            statement.close();
    
            //catch sql exceptions
    } catch (SQLException e) {
        System.out.println("Connection failed. Check output console.");
        e.printStackTrace();
    }
        
    }



}
