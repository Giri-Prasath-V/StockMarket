CREATE TABLE users (
    userid SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    dob DATE NOT NULL,
    balance DECIMAL(10, 2) CHECK (balance <= 100000) NOT NULL
);


INSERT INTO users (username, password, dob, balance)
VALUES 
('rajesh', 'rajesh123', '1995-04-20', 60000.00),
('riya', 'riya456', '1998-07-15', 85000.00),
('swetha', 'swetha789', '1990-12-05', 45000.00);


select * from users;

CREATE TABLE holdings (
    id SERIAL PRIMARY KEY,
    userid INT NOT NULL,
    stockid INT NOT NULL,
    quantity INT NOT NULL,
    purchase_price INT NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (userid) REFERENCES users (userid) ON DELETE CASCADE,
    CONSTRAINT fk_stock FOREIGN KEY (stockid) REFERENCES stock (stock_id) ON DELETE CASCADE
);

INSERT INTO holdings (userid, stockid, quantity, purchase_price)
VALUES
(1, 1, 50, 150.00),
(1, 2, 30, 200.00),
(2, 1, 20, 155.00),
(2, 3, 40, 250.00),
(3, 2, 25, 210.00),
(3, 3, 35, 300.00);


select * from holdings;

CREATE TABLE stock (
    stock_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    quantity INT NOT NULL,
    min_price DECIMAL(10, 2) NOT NULL,
    max_price DECIMAL(10, 2) NOT NULL
);

INSERT INTO stock (name, quantity, min_price, max_price)
VALUES 
('Apple Inc.', 500, 150.00, 180.00),
('Microsoft Corp.', 800, 220.00, 250.00),
('Google LLC', 300, 2700.00, 3000.00),
('Tesla Inc.', 700, 600.00, 750.00);

select * from stock;


CREATE TABLE watchlist (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    stock_id INT NOT NULL,
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (userid) ON DELETE CASCADE,
    CONSTRAINT fk_stock FOREIGN KEY (stock_id) REFERENCES stock (stock_id) ON DELETE CASCADE
);

select * from watchlist;
