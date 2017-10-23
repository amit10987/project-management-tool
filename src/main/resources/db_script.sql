insert into organization(id, name) values(1, 'Golden Real Estate');
 
-- activity ---
INSERT INTO activity(id, name) values(1, 'Cleaning the facade');
INSERT INTO activity(id, name) values(2, 'Fixing Electricity');
INSERT INTO activity(id, name) values(3, 'Renewing the fire extinguishers');
 
-- property--
insert into property(id, name, organization_id) values(1, 'Building A', 1);
insert into property(id, name, organization_id) values(2, 'Building B', 1);
insert into property(id, name, organization_id) values(3, 'Building C', 1);
 
-- employee--
insert into employee(id, firstname, lastname, organization_id) values(1,'Manoj','Kumar',1);
insert into employee(id, firstname, lastname, organization_id) values(2,'Dilip','Singh',1);
insert into employee(id, firstname, lastname, organization_id) values(3,'Shahil','Aggarwal',1);

-- todo -----
INSERT INTO todo(id, enddate, startdate, status, activity_id, employee_id, property_id)
VALUES (1, '2017-10-10', '2017-10-01', 'COMPLETED', 1, 1, 1);
INSERT INTO todo(id, enddate, startdate, status, activity_id, employee_id, property_id)
VALUES (2, '2017-10-19', '2017-10-03', 'COMPLETED', 1, 2, 1);
INSERT INTO todo(id, enddate, startdate, status, activity_id, employee_id, property_id)
VALUES (3, '2017-12-27', '2017-12-06', 'NOT_YET_STARTED', 2, 3, 2);
INSERT INTO todo(id, enddate, startdate, status, activity_id, employee_id, property_id)
VALUES (4, '2017-11-04', '2017-10-16', 'WORK_IN_PROGRESS', 3, 1, 3);
INSERT INTO todo(id, enddate, startdate, status, activity_id, employee_id, property_id)
VALUES (5, '2017-11-04', '2017-10-03', 'WORK_IN_PROGRESS', 1, 2, 3);
INSERT INTO todo(id, enddate, startdate, status, activity_id, employee_id, property_id)
VALUES (6, '2017-11-04', '2017-10-23', 'STARTED', 1, 3, 2);