DROP TABLE IF EXISTS t_timepref;
CREATE TABLE t_timepref (
    id varchar(36) NOT NULL PRIMARY KEY, -- GUID
    rsvpid varchar(36) NOT NULL,
    startInterval TIMESTAMP,
    endInterval TIMESTAMP,
    prefEncoding INT NOT NULL,
    INDEX (rsvpid(8)),
    FOREIGN KEY (rsvpid) REFERENCES t_rsvp (id)
);
