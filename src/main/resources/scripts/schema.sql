CREATE TABLE PRODUCTS
(
    id                 BIGINT PRIMARY KEY AUTO_INCREMENT,
    name               VARCHAR NOT NULL,
    description        VARCHAR NOT NULL,
    base_price         DECIMAL NOT NULL,
    tax_rate           DECIMAL NOT NULL,
    status             VARCHAR NOT NULL,
    inventory_quantity INT     NOT NULL
);

create table users
(
    username varchar_ignorecase(50) not null primary key,
    password varchar(500)           not null,
    enabled  boolean                not null
);

create table authorities
(
    username  varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key (username) references users (username)
);

create unique index ix_auth_username on authorities(username, authority);