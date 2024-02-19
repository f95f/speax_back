create table user_proficiencies(
	id BINARY(16) not null,
	proficiency_id BINARY(16) not null,
	user_id BINARY(16) not null,
    primary key(id)
);
alter table user_proficiencies
	add constraint fk_proficiency
		foreign key (proficiency_id)
		references proficiency(id),
	add constraint fk_user
		foreign key (user_id)
		references user(id);