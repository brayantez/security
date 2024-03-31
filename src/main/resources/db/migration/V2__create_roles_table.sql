create table if not exists roles
(
    id bigint not null primary key,
    role_name text   not null unique
);