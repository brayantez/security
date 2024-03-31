create table if not exists user_roles
(
    role_id bigint not null constraint user_roles_role_id_fk references roles,
    user_id bigint not null constraint user_roles_user_id_fk references users,
    primary key (role_id, user_id)
);