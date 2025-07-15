drop table if exists cards;
create table cards
(
    pan       varchar(16) primary key,
    cif       varchar(10) not null,
    payappno  varchar(18),
    payapptyp smallint    not null
);

create table users
(
    id        int auto_increment primary key,
    username  varchar(20) not null,
    password varchar(20) not null
);
create table roles
(
    id   int auto_increment primary key,
    name varchar(20) not null
);
create table privileges
(
    id   int auto_increment primary key,
    name varchar(20) not null
);
create table users_roles
(
    user_id int references users(id),
    role_id int references roles(id)
);

create table roles_privileges
(
    role_id      int references roles(id),
    privilege_id int references privileges(id)
);