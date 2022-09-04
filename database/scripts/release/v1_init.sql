CREATE DATABASE IF NOT EXISTS db_orderbook;

use db_orderbook;

CREATE TABLE IF NOT EXISTS tbl_order (
    oid INTEGER NOT NULL auto_increment,
    user_id VARCHAR(10) NOT NULL,
    `timestamp` DATETIME NOT NULL,
    booking_date DATE NOT NULL,
    booking_time TIME NOT NULL,
    price DECIMAL NOT NULL,
    loc_1 text,
    loc_2 text,
    order_status VARCHAR(20),
    PRIMARY KEY (oid)
);

CREATE TABLE IF NOT EXISTS tbl_audit (
    oid INTEGER NOT NULL auto_increment,
    order_id INTEGER NOT NULL,
    user_id VARCHAR(10) NOT NULL,
    `timestamp` DATETIME NOT NULL,
    booking_date DATE NOT NULL,
    booking_time TIME NOT NULL,
    price DECIMAL NOT NULL,
    loc_1 text,
    loc_2 text,
    order_status VARCHAR(20),
    PRIMARY KEY (oid),
    FOREIGN KEY (order_id) REFERENCES tbl_order(oid)
);

