drop table if exists card;
create table card
(
    pan       varchar(16) primary key,
    cif       varchar(10) not null,
    payappno  varchar(18),
    payapptyp smallint    not null
);
create table users
(
    id        int primary key,
    username  varchar(20) not null,
    passwords varchar(20) not null
);
create table users_roles
(
    user_id int foreign key references users(id),
    role_id int foreign key references roles(id)
);
create table roles
(
    id   int primary key,
    name varchar(20) not null
);
create table roles_prvlg
(
    role_id      int foreign key references roles(id),
    privilege_id int foreign key references prvlg(id)
);
create table prvlg
(
    id   int primary key,
    name varchar(20) not null
);


