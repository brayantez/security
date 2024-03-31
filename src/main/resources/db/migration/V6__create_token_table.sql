create table if not exists token
(
    expired   boolean not null,
    revoked   boolean not null,
    id  bigint  not null  primary key,
    user_id  bigint constraint fkj8rfw4x0wjjyibfqq566j4qng references users,
    token  varchar(255) unique,
    token_type varchar(255) constraint token_token_type_check  check ((token_type)::text = 'BEARER'::text)
);

