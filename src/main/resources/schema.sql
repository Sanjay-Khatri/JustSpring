create table if not exists user(
	id int not null primary key auto_increment,
	firstname varchar(50) not null,
	lastname varchar(50) not null,
	ssn varchar(50) not null
);