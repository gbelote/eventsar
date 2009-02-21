DROP TABLE IF EXISTS t_urlabbr;
CREATE TABLE t_urlabbr (
    id varchar(16) NOT NULL PRIMARY KEY, -- Alphanumeric clump
    uri varchar(2000) NOT NULL
);
