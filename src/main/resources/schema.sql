
DROP TABLE IF EXISTS ACCOUNT_LOG;
DROP TABLE IF EXISTS ACCOUNT;
DROP TABLE IF EXISTS FIGHTER;


CREATE TABLE ACCOUNT (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    FORE_NAME VARCHAR(50) NOT NULL,
    SUR_NAME VARCHAR(50) NOT NULL,
    BIRTH_DATE DATE NOT NULL,
    CURRENCY_CODE VARCHAR(255)
);

CREATE TABLE ACCOUNT_LOG (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    OPERATION_TYPE VARCHAR(50) NOT NULL,
    TIME_STAMP TIMESTAMP NOT NULL,
    ACCOUNT_ID BIGINT,
    CONSTRAINT FK_ACCOUNT_LOG_ACCOUNT FOREIGN KEY (ACCOUNT_ID) REFERENCES ACCOUNT(ID)
);

INSERT INTO ACCOUNT (FORE_NAME, SUR_NAME, BIRTH_DATE, CURRENCY_CODE)
VALUES
    ('John', 'Doe', '1990-05-15', 'USD'),
    ('Jane', 'Smith', '1985-08-22', 'EUR'),
    ('Michael', 'Johnson', '1978-12-10', 'GBP'),
    ('Emily', 'Williams', '1995-03-28', 'CAD'),
    ('David', 'Brown', '1982-07-17', 'AUD'),
    ('Sarah', 'Jones', '1998-11-03', 'JPY'),
    ('Daniel', 'Miller', '1989-09-12', 'CHF'),
    ('Olivia', 'Davis', '1992-06-07', 'INR'),
    ('William', 'Wilson', '1984-04-25', 'SGD'),
    ('Sophia', 'Moore', '1997-01-19', 'HKD');

INSERT INTO ACCOUNT_LOG (OPERATION_TYPE, TIME_STAMP, ACCOUNT_ID)
VALUES
    ('CREATE', '2023-08-01 10:15:00', 1),
    ('UPDATE', '2023-08-02 14:30:00', 2),
    ('DELETE', '2023-08-03 08:45:00', 3),
    ('CREATE', '2023-08-04 12:00:00', 4),
    ('UPDATE', '2023-08-05 15:30:00', 5),
    ('CREATE', '2023-08-06 09:15:00', 6),
    ('UPDATE', '2023-08-07 11:00:00', 7),
    ('CREATE', '2023-08-08 13:45:00', 8),
    ('DELETE', '2023-08-09 16:00:00', 9),
    ('CREATE', '2023-08-10 07:30:00', 10);


    CREATE TABLE FIGHTER (
        ID BIGINT AUTO_INCREMENT PRIMARY KEY,
        FIGHTER_NAME VARCHAR(100),
        NICK_NAME VARCHAR(100),
        NATIONALITY VARCHAR(50),
        BIRTH_DATE VARCHAR(50),
        HEIGHT VARCHAR(10),
        WEIGHT VARCHAR(10),
        ASSOCIATION VARCHAR(100),
        KO_TKO_WIN INT,
        KO_TKO_WIN_PERCENTAGE DOUBLE,
        SUBMISSION_WIN INT,
        SUBMISSION_WIN_PERCENTAGE DOUBLE,
        DECISION_WIN INT,
        DECISION_WIN_PERCENTAGE DOUBLE,
        KO_TKO_LOSS INT,
        KO_TKO_LOSS_PERCENTAGE DOUBLE,
        SUBMISSION_LOSS INT,
        SUBMISSION_LOSS_PERCENTAGE DOUBLE,
        DECISION_LOSS INT,
        DECISION_LOSS_PERCENTAGE DOUBLE,
        DRAWS INT,
        NO_CONTEST INT,
        CREATED_AT DATETIME,
        UPDATED_AT DATETIME,
        PROFILE_IMAGE_URL VARCHAR(255)
    );

INSERT INTO FIGHTER (FIGHTER_NAME, NICK_NAME, NATIONALITY, BIRTH_DATE, HEIGHT, WEIGHT, ASSOCIATION, KO_TKO_WIN, KO_TKO_WIN_PERCENTAGE, SUBMISSION_WIN, SUBMISSION_WIN_PERCENTAGE, DECISION_WIN, DECISION_WIN_PERCENTAGE, KO_TKO_LOSS, KO_TKO_LOSS_PERCENTAGE, SUBMISSION_LOSS, SUBMISSION_LOSS_PERCENTAGE, DECISION_LOSS, DECISION_LOSS_PERCENTAGE, DRAWS, NO_CONTEST, CREATED_AT, UPDATED_AT, PROFILE_IMAGE_URL)
VALUES
('Mike Johnson', 'The Hammer', 'Canada', '1988-08-20', '6''0"', '185 lbs', 'Bellator', 8, 40.0, 7, 35.0, 4, 20.0, 3, 15.0, 2, 10.0, 1, 5.0, 2, 0, '2023-09-19 11:15:00', '2023-09-19 11:15:00', 'https://example.com/mikejohnson.jpg'),
('Anna Smith', 'The Assassin', 'Australia', '1992-03-10', '5''8"', '135 lbs', 'ONE Championship', 12, 60.0, 6, 30.0, 2, 10.0, 3, 15.0, 1, 5.0, 0, 0.0, 4, 1, '2023-09-19 12:00:00', '2023-09-19 12:00:00', 'https://example.com/annasmith.jpg'),
('Carlos Rodriguez', 'The Tank', 'Mexico', '1991-12-05', '5''11"', '170 lbs', 'UFC', 9, 45.0, 4, 20.0, 5, 25.0, 2, 10.0, 3, 15.0, 1, 5.0, 2, 0, '2023-09-19 13:30:00', '2023-09-19 13:30:00', 'https://example.com/carlosrodriguez.jpg'),
('Emily Davis', 'The Fury', 'USA', '1993-06-25', '5''6"', '125 lbs', 'Invicta FC', 7, 35.0, 5, 25.0, 3, 15.0, 4, 20.0, 1, 5.0, 2, 10.0, 2, 0, '2023-09-19 14:45:00', '2023-09-19 14:45:00', 'https://example.com/emilydavis.jpg'),
('David Lee', 'The Dominator', 'Canada', '1990-09-12', '6''1"', '155 lbs', 'Rizin FF', 11, 55.0, 6, 30.0, 2, 10.0, 4, 20.0, 3, 15.0, 1, 5.0, 2, 0, '2023-09-19 15:20:00', '2023-09-19 15:20:00', 'https://example.com/davidlee.jpg'),
('Sarah Mitchell', 'The Scrapper', 'UK', '1994-04-03', '5''7"', '145 lbs', 'Cage Warriors', 8, 40.0, 4, 20.0, 3, 15.0, 5, 25.0, 2, 10.0, 1, 5.0, 3, 0, '2023-09-19 16:10:00', '2023-09-19 16:10:00', 'https://example.com/sarahmitchell.jpg'),
('Daniel White', 'The Destroyer', 'USA', '1993-11-18', '6''3"', '205 lbs', 'Strikeforce', 9, 45.0, 6, 30.0, 2, 10.0, 3, 15.0, 2, 10.0, 2, 10.0, 1, 0, '2023-09-19 17:05:00', '2023-09-19 17:05:00', 'https://example.com/danielwhite.jpg'),
('Luis Martinez', 'The Technician', 'Mexico', '1989-07-08', '5''10"', '155 lbs', 'WEC', 10, 50.0, 4, 20.0, 5, 25.0, 3, 15.0, 2, 10.0, 1, 5.0, 2, 0, '2023-09-19 18:20:00', '2023-09-19 18:20:00', 'https://example.com/luismartinez.jpg'),
('Sophia Brown', 'The Sniper', 'Canada', '1992-02-14', '5''9"', '135 lbs', 'PFL', 7, 35.0, 3, 15.0, 4, 20.0, 2, 10.0, 1, 5.0, 2, 10.0, 3, 0, '2023-09-19 19:45:00', '2023-09-19 19:45:00', 'https://example.com/sophiabrown.jpg');





