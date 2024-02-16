create table users(
	id int not null auto_increment primary key,
    firstName varchar(128) not null,
    lastName varchar(128) not null,
    email varchar(128) not null,
    password varchar(128) not null,
    phone varchar(20),
    bio varchar(512),
    birthDate date not null,
    isActive boolean,
    birthLocation_id int,
    currentLocation_id int,
    userRole varchar(32),
	createdAt date,
    updatedAt date
);
alter table users
	add constraint uk_email unique(email),
    add constraint uk_phone unique(phone),
    add constraint fk_birthLocation
		foreign key (birthLocation_id) references location(id),
    add constraint fk_currentLocation
		foreign key (currentLocation_id) references location(id);