create table location(
	id BINARY(16) not null,
    country varchar(128) not null,
    city varchar(256),

    primary key(id)
);