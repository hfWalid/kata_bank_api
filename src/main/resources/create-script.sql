/*------------------------------------------------------------
 -- Table: statement
 ------------------------------------------------------------*/
create TABLE statement(
                          id SERIAL PRIMARY KEY,
                          statement_amount FLOAT,
                          statement_date DATE,
                          statement_type VARCHAR (50)
);

/*------------------------------------------------------------
 -- Table: account
 ------------------------------------------------------------*/
create TABLE account(
                        id SERIAL PRIMARY KEY,
                        statement_id INT,
                        account_number FLOAT,
                        balance FLOAT,
                        FOREIGN KEY (statement_id) REFERENCES statement(id)
);
