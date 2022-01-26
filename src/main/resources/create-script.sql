/*------------------------------------------------------------
 -- Table: kata_user
 ------------------------------------------------------------*/
create TABLE kata_user(
                          id SERIAL PRIMARY KEY,
                          user_name VARCHAR (50),
                          password VARCHAR (50)
);

/*------------------------------------------------------------
 -- Table: account
 ------------------------------------------------------------*/
create TABLE account(
                        id SERIAL PRIMARY KEY,
                        kata_user_id INT,
                        account_number FLOAT,
                        balance FLOAT,
                        FOREIGN KEY (kata_user_id) REFERENCES kata_user(id)
);

/*------------------------------------------------------------
 -- Table: statement
 ------------------------------------------------------------*/
create TABLE statement(
                          id SERIAL PRIMARY KEY,
                          account_id INT,
                          statement_amount FLOAT,
                          statement_date DATE,
                          statement_type VARCHAR (50),
                          FOREIGN KEY (account_id) REFERENCES account(id)
);
