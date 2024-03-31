create table if not exists users
(
    created_by       integer  not null,
    last_modified_by integer,
    create_date      timestamp(6) not null,
    id  bigint       not null primary key,
    last_modified    timestamp(6),
    email text       not null unique,
    first_name       text  not null,
    last_name        text  not null,
    password         text  not null
);