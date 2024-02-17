create table user(
    id BINARY(16) not null,
    first_name varchar(128) not null,
    last_name varchar(128) not null,
    email varchar(128) not null,
    password varchar(128) not null,
    phone varchar(20),
    bio varchar(512),
    birth_date date not null,
    is_active boolean,
    birth_location_id BINARY(16),
    current_location_id BINARY(16),
    user_role varchar(32),
    created_at date,
    updated_at date,

    primary key(id)
);
alter table user
    add constraint uk_email unique(email),
    add constraint uk_phone unique(phone),
    add constraint fk_birth_location
        foreign key (birth_location_id) references location(id),
    add constraint fk_current_location
        foreign key (current_location_id) references location(id);
