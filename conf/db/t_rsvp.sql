DROP TABLE IF EXISTS t_rsvp;
CREATE TABLE t_rsvp (
    id varchar(36) NOT NULL PRIMARY KEY, -- GUID
    eventid varchar(36) NOT NULL,
    userid varchar(36) NOT NULL,
    INDEX (eventid(8)),
    INDEX (userid(8)),
    FOREIGN KEY (eventid) REFERENCES t_event (id),
    FOREIGN KEY (userid) REFERENCES t_user (id)
);
