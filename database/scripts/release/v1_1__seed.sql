use db_orderbook;

INSERT INTO tbl_order (oid, user_id, timestamp, booking_date, booking_time, price, loc_1, loc_2, order_status)
VALUES (1, 'SYSTEM', NOW(), '2022-01-01', '10:00:00', 100, 'n/a', 'n/a', 'PROPOSED');

INSERT INTO tbl_audit (oid, order_id, user_id, timestamp, booking_date, booking_time, price, loc_1, loc_2, order_status)
VALUES (1, 1, 'SYSTEM', NOW(), '2022-01-01', '10:00:00', 100, 'n/a', 'n/a', 'PROPOSED');
