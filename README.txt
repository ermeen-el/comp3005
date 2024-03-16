Nermeen El-Sherbiny 
101263616






Step 1:
Create a database called “student” in pgAdmin4


Step 2:
Create a new table using this create statement:


CREATE TABLE Students(
student_id SERIAL PRIMARY KEY,
first_name VARCHAR(255) NOT NULL,
last_name VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL UNIQUE,
enrollment_date DATE
);




Step 3:


Add base values for testing 


INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');






  



Step 4: 


In VSCode, download the extension called “Extension Pack for Java”


  





Step 5: 


Open VSCode and on the left side 


  



Create a new maven project 


Click on “maven-archetype-quickstart”


Then on “1.4”


Pick whatever name for artifact Id


Pick a directory 


For where it say “Define value for property 'version' 1.0-SNAPSHOT:”, enter “1.0” and then for where is say “Y:” enter “y”




Step 6: 


In the pom.xml file, add the following between “<dependencies>” and “</dependencies>”
If its doesnt exist, write it yourself 
   
            <dependency>
                <groupId>org.postgresql</groupId>
                <artifactId>postgresql</artifactId>
                <version>42.7.2</version>
            </dependency>
 






Step 7: 


Then to run the code, you can call any of the functions in the main with the correct parameters and run the code to see the results. The results should also show in the database


  



Username and password should be changed to whatever you use to sign in on your postgres 












Youtube link:




https://youtu.be/aa9zShd-HfE