create table if not exists role_permissions
(
    permission_id bigint not null constraint role_permission_permission_id_fk references permissions,
    role_id bigint not null constraint role_permission_role_id_fk references roles,
    primary key (permission_id, role_id)
);

