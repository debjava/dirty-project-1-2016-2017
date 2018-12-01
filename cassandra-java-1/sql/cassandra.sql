-- This script will help you to know about cassandra basics

--drop a keyspace if exists
drop KEYSPACE test1;

--create a keyspace
CREATE KEYSPACE test1
	WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

-- See all the keyspaces
describe keyspaces;

-- Drop table if exists
drop table test1.employees;

-- Date format will be  --format will be yyyy-mm-dd HH:mm:ssZ
CREATE TABLE test1.employees (
   empId int PRIMARY KEY,
   empName text,
   empDesgn text,
   empAddress text,
   empPhone varint,
   empSal varint,
   createdDate timestamp,
   updatedDate timestamp
);

--create required indexes
CREATE INDEX eadddres ON test1.employees (empAddress);

--Drop index if required
drop index test1.eadddres;

create index edesgn ON test1.employees (empDesgn);

/* Insert some values */
INSERT INTO test1.employees (empId, empName, empDesgn,empAddress, empPhone,empSal, createdDate, updatedDate)
   VALUES(1,'Deb', 'Technical Architect', 'Bangalore', 981234567, 5000,toTimestamp('2016-11-13'),null);

INSERT INTO test1.employees (empId, empName, empDesgn,empAddress, empPhone,empSal, createdDate, updatedDate)
   VALUES(2,'John', 'Solutions Architect', 'Bangalore', 981234567, 6000,toTimestamp('2016-11-13'),null);

INSERT INTO test1.employees (empId, empName, empDesgn,empAddress, empPhone,empSal, createdDate, updatedDate)
   VALUES(3,'Ram', 'Project Manager', 'Bhubaneswar', 981234337, 3000,toTimestamp('2016-11-13'),null);

INSERT INTO test1.employees (empId, empName, empDesgn,empAddress, empPhone,empSal, createdDate, updatedDate)
   VALUES(4,'Vidya', 'Project Lead', 'Mumbai', 981234457, 2000,toTimestamp('2016-11-13'),null);

INSERT INTO test1.employees (empId, empName, empDesgn,empAddress, empPhone,empSal, createdDate, updatedDate)
   VALUES(5,'Katrina', 'Tecnical Staff', 'Pune', 981232267, 5000,toTimestamp('2016-11-13'),null);

INSERT INTO test1.employees (empId, empName, empDesgn,empAddress, empPhone,empSal, createdDate, updatedDate)
   VALUES(6,'Karina', 'Team Lead', 'Chennai', 981244267, 3000,toTimestamp('2016-10-13'),null);

INSERT INTO test1.employees (empId, empName, empDesgn,empAddress, empPhone,empSal, createdDate, updatedDate)
   VALUES(7,'Nanabati', 'Developer', 'Chennai', 983244267, 3000,toTimestamp('2016-10-13'),null);

-- If you insert once again , there will be no problem unlike Oracle Database
INSERT INTO test1.employees (empId, empName, empDesgn,empAddress, empPhone,empSal, createdDate, updatedDate)
   VALUES(7,'Nanabati', 'Developer', 'Chennai', 983244267, 3000,toTimestamp('2016-10-13'),null);

-- Update a row
update test1.employees set empDesgn = 'Team Member', updatedDate = toTimestamp('2016-11-13') where empId = 6;

--Delete a row
delete from test1.employees where empId = 7 ;
delete from test1.employees where empId = 8;

-- Select operations
select * from test1.employees;

select empId, empName,empDesgn,empAddress,empPhone,empSal, createdDate, updatedDate
	from test1.employees ;


