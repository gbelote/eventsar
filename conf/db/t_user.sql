DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user (
    id varchar(36) NOT NULL PRIMARY KEY, -- GUID
    email varchar(320) NOT NULL,
    UNIQUE (email),
    INDEX (email(32))
);
