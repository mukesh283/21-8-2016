create table role(roleid int primary key,name text,description text);
create table project(projectid int primary key,name text,departmentid int,description text,foreign key departmentid references department(departmentid));
create table department(departmentid int primary key,name text,description text);


create table employee(employeeid int auto_increment,name  text,kinid text,emailid text unique,phnNo long,dob text,doj text,address text,depid int,prjid int, roleid int,foreign key depid references department(departmentid),foreign key (prjid) references project(projectid),foreign key (roleid) references role(roleid));
	