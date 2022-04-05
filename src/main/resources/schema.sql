Create table student(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    full_Name VARCHAR(400) NOT NULL,
    registration VARCHAR(100) NOT NULL,
    card_number VARCHAR(100) NOT NULL,
    reg_card_number VARCHAR(200) NOT NULL,
    email VARCHAR(250) NOT NULL,
    date_created VARCHAR(100) NOT NULL,
    date_updated VARCHAR(100) NOT NULL,
    active BOOL NOT NULL DEFAULT TRUE
);