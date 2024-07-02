CREATE TABLE tasks
(
    id BIGINT not null primary key auto_increment,
    summary VARCHAR(256) not null ,
    description TEXT,
    status VARCHAR(256) not null
);