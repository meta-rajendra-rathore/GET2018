use employee_portal;
show tables;

INSERT INTO EMPLOYEE 
(emp_code, first_name, last_name, dob, gender, primary_contact_number, secondary_contact_number, email_id, skype_id, profile_picture, password, enabled) 
VALUES 
(1234, 'Rajendra', 'Rathore', '1996-06-05', 'M', 7737, 80044, 'eaj', 'eaj', 'dp', 'pass', 1);

UPDATE EMPLOYEE SET first_name = ?, last_name = ?, dob = ?, gender = ?, primary_contact_number = ?, secondary_contact_number = ?, email_id = ?, skype_id = ?, profile_picture = ?, enabled = ?;