CREATE TABLE IF NOT EXISTS Stocks (
  id SERIAL PRIMARY KEY,
  name VARCHAR(30),
  isin VARCHAR(30),
  volume INTEGER
);