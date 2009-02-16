DROP TABLE IF EXISTS t_event;
CREATE TABLE t_event (
    id varchar(36) NOT NULL PRIMARY KEY, -- GUID
    startInterval TIMESTAMP,
    endInterval TIMESTAMP,
    statusEncoding INT NOT NULL
);
