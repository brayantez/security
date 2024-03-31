create table if not exists permissions
(
    id bigint not null primary key,
    permission_name text not null  unique
);