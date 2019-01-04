create table hibernate_sequence (next_val bigint);
insert into hibernate_sequence values ( 1 )
create table message (
  id bigint not null,
  qwest varchar(2048),
  email varchar(255),
  name varchar(255),
  number_phone varchar(255),
  theme_qwest varchar(255),
  primary key (id)
);