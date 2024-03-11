create table users
(
    id       bigserial primary key,
    email    varchar(255),
    password varchar(255)
);
create table tasks
(
    id          bigserial primary key,
    user_id     bigint references users (id),
    title       varchar(255),
    description varchar(255),
    created     date default current_date,
    deadline    date,
    stat        varchar(255)
);