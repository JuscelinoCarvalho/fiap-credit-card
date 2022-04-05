Create table student(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    full_Name VARCHAR(400) NOT NULL,
    registration VARCHAR(100) NOT NULL,
    card_number VARCHAR(100) NOT NULL,
    reg_card_number VARCHAR(200) NOT NULL,
    email VARCHAR(250) NOT NULL,
    date_created VARCHAR(50) NOT NULL,
    date_updated VARCHAR(50) NOT NULL,
    active BOOL NOT NULL DEFAULT TRUE
);

Create table transactions(
   id INTEGER PRIMARY KEY AUTO_INCREMENT,
    transaction_number VARCHAR(200) NOT NULL,
    reg_card_number VARCHAR(100) NOT NULL,
    transactionValue DECIMAL(19,10) NOT NULL,
    totalAmount DECIMAL(19,10) NOT NULL,
    installments INTEGER DEFAULT 0,
    date_in VARCHAR(50) NOT NULL,    
    status VARCHAR(50) NOT NULL,
    active BOOL NOT NuLL DEFAULT TRUE
);