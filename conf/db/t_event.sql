DROP TABLE IF EXISTS t_event;
CREATE TABLE t_event (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    startInterval TIMESTAMP,
    endInterval TIMESTAMP,
    statusEncoding INT NOT NULL
);
