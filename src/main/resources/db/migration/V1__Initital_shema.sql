create table customers (
    id bigserial primary key ,
    first_name varchar(255) not null ,
    last_name varchar(255) not null,
    location varchar(255) not null
);