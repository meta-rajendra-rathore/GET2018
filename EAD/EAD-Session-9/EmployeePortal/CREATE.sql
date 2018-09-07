create database employee_portal;

use employee_portal;

create table employee(
   emp_code INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
   first_name VARCHAR(100) NOT NULL,
   last_name VARCHAR(100),
   dob DATE NOT NULL,
   gender VARCHAR(1) NOT NULL,
   primary_contact_number VARCHAR(10),
   secondary_contact_number VARCHAR(10),
   email_id VARCHAR(100) NOT NULL UNIQUE,
   skype_id VARCHAR(100),
   profile_picture VARCHAR(512),
   password VARCHAR(100) NOT NULL,
   enabled BOOLEAN DEFAULT true
   );
   
CREATE TABLE job_title_master(
   job_code INT PRIMARY KEY,
   job_title VARCHAR(100) NOT NULL UNIQUE
   );
   
CREATE TABLE user_roles(
   user_role_id INT PRIMARY KEY AUTO_INCREMENT,
   user_name VARCHAR(200) NOT NULL UNIQUE,
   role VARCHAR(50) NOT NULL    
);

CREATE TABLE skill_master(
   skill_id INT PRIMARY KEY,
   skill_name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE employee_skills(
   emp_skill_id INT PRIMARY KEY,
   emp_code INT NOT NULL,
   skill_code INT NOT NULL,
   FOREIGN KEY (emp_code)  REFERENCES employees(emp_code),
   FOREIGN KEY (skill_code)  REFERENCES skill_master(skill_id)
);



CREATE TABLE project_master(
   project_id INT PRIMARY KEY,
   description VARCHAR(200) NOT NULL,
   start_date DATE NOT NULL,
   end_date DATE,
   project_logo VARCHAR(100)
);

CREATE TABLE address(
   address_id INT PRIMARY KEY,
   emp_code INT NOT NULL,
   add_line_1 VARCHAR(100) NOT NULL,
   add_line_2 VARCHAR(100),
   FOREIGN KEY (emp_code) REFERENCES employees(emp_code)
);