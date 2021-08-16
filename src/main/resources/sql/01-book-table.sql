drop table if exists public.books;
create table public.books
(
    id     BIGINT unique not null primary key
        GENERATED BY DEFAULT AS IDENTITY,
    name   VARCHAR(60)   not null,
    author VARCHAR(30)   not null,
    price  numeric(6, 2) not null
);
