drop table if exists card;
create table card(
    pan varchar(16) primary key,
    cif varchar(10) not null,
    payappno varchar(18),
    payapptyp smallint not null
);

