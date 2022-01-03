create sequence address_seq start with 1 increment by 1;
CREATE TABLE address
(
    ID  int NOT NULL default nextval('address_seq') PRIMARY KEY,
    street_name varchar(60) NOT NULL,
    street_number varchar(60) NOT NULL,
    post_code int NOT NULL,
    city varchar(60) NOT NULL
)