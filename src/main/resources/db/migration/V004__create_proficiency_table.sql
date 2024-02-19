create table proficiency(
	id BINARY(16) not null,
    language_id BINARY(16) not null,
    level varchar(32) not null default 'BEGINNER',
    primary key(id)
);
alter table proficiency
	add constraint fk_language
    foreign key (language_id)
    references language(id);