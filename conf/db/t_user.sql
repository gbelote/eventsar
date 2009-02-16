DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user (
    id varchar(36) NOT NULL DEFAULT 'uuid()',
    email varchar(320) NOT NULL
);
