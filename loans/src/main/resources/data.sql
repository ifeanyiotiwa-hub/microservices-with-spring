DROP TABLE IF EXISTS loans;

CREATE TABLE loans (
  loan_number BIGINT PRIMARY KEY AUTO_INCREMENT,
  customer_id INT NOT NULL,
  start_date DATE NOT NULL,
  loan_type VARCHAR(255) NOT NULL,
  total_loan INT NOT NULL,
  outstanding_amount INT NOT NULL,
  amount_paid INT NOT NULL,
  created_date DATE DEFAULT NULL
);


INSERT INTO loans(customer_id, start_date, loan_type, total_loan, outstanding_amount, amount_paid,
                  created_date)
    VALUES (
      1, '2020-10-13', 'Home', 200000, 50000, 150000, '2020-10-13'
    );

INSERT INTO loans(customer_id, start_date, loan_type, total_loan, outstanding_amount, amount_paid,
                  created_date)
    VALUES (
      1, '2020-06-06', 'Vehicle', 40000, 10000, 30000, '2020-10-13'
    );

INSERT INTO loans(customer_id, start_date, loan_type, total_loan, outstanding_amount, amount_paid,
                  created_date)
    VALUES (
      1, '2021-02-14', 'Home', 50000, 40000, 10000, '2020-10-13'
    );

INSERT INTO loans(customer_id, start_date, loan_type, total_loan, outstanding_amount, amount_paid,
                  created_date)
    VALUES (
      1, '2019-02-13', 'Personal', 10000, 3500, 6500, '2020-10-13'
    );