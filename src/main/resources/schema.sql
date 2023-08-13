
DROP TABLE IF EXISTS ACCOUNT_LOG;
DROP TABLE IF EXISTS ACCOUNT;


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


