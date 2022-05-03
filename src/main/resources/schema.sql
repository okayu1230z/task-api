DROP TABLE IF EXISTS task;

-- タスク
CREATE TABLE task
(
    id         int           not null auto_increment,
    task_desc  varchar(1000) not null,
    done       boolean       not null default false,
    created_at timestamp     not null,
    updated_at timestamp,
    primary key (id)
);