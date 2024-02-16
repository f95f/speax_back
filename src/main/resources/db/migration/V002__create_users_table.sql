create table user(
	id BINARY(16) not null,
    firstName varchar(128) not null,
    lastName varchar(128) not null,
    email varchar(128) not null,
    password varchar(128) not null,
    phone varchar(20),
    bio varchar(512),
    birthDate date not null,
    isActive boolean,
    birthLocation_id BINARY(16),
    currentLocation_id BINARY(16),
    userRole varchar(32),
	createdAt date,
    updatedAt date,

    primary key(id)
);
alter table user
	add constraint uk_email unique(email),
    add constraint uk_phone unique(phone),
    add constraint fk_birthLocation
		foreign key (birthLocation_id) references location(id),
    add constraint fk_currentLocation
		foreign key (currentLocation_id) references location(id);