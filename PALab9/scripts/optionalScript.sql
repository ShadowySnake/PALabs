drop table people CASCADE CONSTRAINTS
/
drop table optmovie CASCADE CONSTRAINTS
/
drop sequence people_incrementer
/
drop sequence movies_incrementer
/
create table people(
    id integer not null,
    name VARCHAR2(100) not null,
    job VARCHAR2(10) not null,

    constraint peopleId primary key (id)
);
/
create table optmovie(
    id integer not null,
    title VARCHAR2(100) not null,
    score integer not null,
    duration integer not null
    release_date DATE not null,

    constraint optMovieId primary (id)
);
/
create sequence people_incrementer
/
create sequence movies_incrementer
/
CREATE OR REPLACE TRIGGER people_inserter
    BEFORE INSERT
    ON people
    FOR EACH ROW
BEGIN
    SELECT people_incrementer.nextval INTO :new.id
    FROM dual;
END;
/
CREATE OR REPLACE TRIGGER movies_inserter
    BEFORE INSERT
    ON optmovie
    FOR EACH ROW
BEGIN
    SELECT movies_incrementer.nextval INTO :new.id
    FROM dual;
END;
/