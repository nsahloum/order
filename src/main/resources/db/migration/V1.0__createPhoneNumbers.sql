create sequence phone_number_seq start with 1 increment by 1;
CREATE TABLE phone_number
(
    ID  int NOT NULL default nextval('phone_number_seq') PRIMARY KEY,
    PREFIX varchar(60) NOT NULL,
    NUMBER varchar(60) NOT NULL
)