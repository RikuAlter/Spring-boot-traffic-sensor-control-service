create table sensor
(
	id varchar(10) not null,
	status varchar(255) not null,
	direction varchar(255) not null,
	location varchar(255) not null,
	primary key (id)
);