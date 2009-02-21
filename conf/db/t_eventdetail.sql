DROP TABLE IF EXISTS t_eventdetail;
CREATE TABLE t_eventdetail (
    id varchar(36) NOT NULL PRIMARY KEY, -- GUID
    eventid varchar(36) NOT NULL,
    name varchar(255) NOT NULL,
    value varchar(1023),
    INDEX (eventid(8)),
    FOREIGN KEY (eventid) REFERENCES t_event (id)
);
