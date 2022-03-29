DROP TABLE IF EXISTS cards;

CREATE TABLE cards(
    card_id INT PRIMARY KEY AUTO_INCREMENT,
    card_number VARCHAR(255) NOT NULL,
    customer_id INT NOT NULL,
    card_type VARCHAR(255) NOT NULL,
    total_limit INT NOT NULL,
    amount_used INT NOT NULL,
    available_amount INT NOT NULL,
    created_date DATE DEFAULT NULL
);

INSERT INTO cards (card_number, customer_id, card_type, total_limit, amount_used, available_amount, created_date)
VALUES ('4565XXXXX4565', 1, 'CREDIT', 10000, 1000, 9000, CURDATE());

INSERT INTO cards (card_number, customer_id, card_type, total_limit, amount_used, available_amount, created_date)
VALUES ('3455XXXXX8673', 1, 'CREDIT', 7500, 600, 6900, CURDATE());

INSERT INTO cards (card_number, customer_id, card_type, total_limit, amount_used, available_amount, created_date)
VALUES ('2359XXXXX9346', 1, 'CREDIT', 20000, 4000, 16000, CURDATE());