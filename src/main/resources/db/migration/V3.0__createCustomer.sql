create sequence customer_seq start with 1 increment by 1;
create table customer
(
    ID int NOT NULL default nextval('customer_seq') PRIMARY KEY,
    first_name varchar(60) NOT NULL,
    last_name varchar(60) NOT NULL,
    email varchar(60) NOT NULL,
    fk_address int NOT NULL,
    fk_phone_number int NOT NULL,
    username varchar(60) NOT NULL,
    password varchar(60) NOT NULL,

    CONSTRAINT FK_CUSTOMER_ADDRESS foreign key (FK_ADDRESS) references ADDRESS (ID),
    CONSTRAINT FK_CUSTOMER_PHONE_NUMBER foreign key (FK_PHONE_NUMBER) references PHONE_NUMBER (ID)

)