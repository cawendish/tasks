CREATE DATABASE book_base;

USE book_base;

CREATE TABLE authors (
  id int(11) NOT NULL AUTO_INCREMENT,
  surname varchar(45) NOT NULL,
  firstname varchar(45) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE books (
  id int(11) NOT NULL AUTO_INCREMENT,
  title varchar(45) NOT NULL,
  page_count int(11) NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE authors_books (
  id int(11) NOT NULL AUTO_INCREMENT,
  author_id int(11) NOT NULL,
  book_id int(11) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (author_id) REFERENCES authors (id),
  FOREIGN KEY (book_id) REFERENCES books (id)
);

INSERT INTO authors (surname,firstname) VALUES ('Adamson','Thomas');
INSERT INTO authors (surname,firstname) VALUES ('Carter','Joseph');
INSERT INTO authors (surname,firstname) VALUES ('Cramer','Ellie');
INSERT INTO authors (surname,firstname) VALUES ('Marlow','David');
INSERT INTO authors (surname,firstname) VALUES ('Paterson','Alex');
INSERT INTO authors (surname,firstname) VALUES ('Smith','Amy');
INSERT INTO authors (surname,firstname) VALUES ('Freeman','Maria');
INSERT INTO authors (surname,firstname) VALUES ('Taylor','Katie');
INSERT INTO authors (surname,firstname) VALUES ('Wood','Louis');
INSERT INTO authors (surname,firstname) VALUES ('Dyson','Teddy');

INSERT INTO books (title,page_count) VALUES ('Morning',120);
INSERT INTO books (title,page_count) VALUES ('Winter',215);
INSERT INTO books (title,page_count) VALUES ('Monday',56);
INSERT INTO books (title,page_count) VALUES ('Birds',198);
INSERT INTO books (title,page_count) VALUES ('Lighthouse',76);
INSERT INTO books (title,page_count) VALUES ('Sea',244);
INSERT INTO books (title,page_count) VALUES ('Pines',96);
INSERT INTO books (title,page_count) VALUES ('Wind',88);
INSERT INTO books (title,page_count) VALUES ('Seagull',147);
INSERT INTO books (title,page_count) VALUES ('Spring',112);

INSERT INTO authors_books (author_id,book_id) VALUES (1,1);
INSERT INTO authors_books (author_id,book_id) VALUES (2,2);
INSERT INTO authors_books (author_id,book_id) VALUES (3,3);
INSERT INTO authors_books (author_id,book_id) VALUES (1,4);
INSERT INTO authors_books (author_id,book_id) VALUES (1,5);
INSERT INTO authors_books (author_id,book_id) VALUES (2,5);
INSERT INTO authors_books (author_id,book_id) VALUES (3,5);
INSERT INTO authors_books (author_id,book_id) VALUES (2,6);
INSERT INTO authors_books (author_id,book_id) VALUES (3,6);
INSERT INTO authors_books (author_id,book_id) VALUES (4,7);
INSERT INTO authors_books (author_id,book_id) VALUES (5,8);
INSERT INTO authors_books (author_id,book_id) VALUES (6,9);
INSERT INTO authors_books (author_id,book_id) VALUES (7,10);
INSERT INTO authors_books (author_id,book_id) VALUES (8,9);
INSERT INTO authors_books (author_id,book_id) VALUES (9,10);
INSERT INTO authors_books (author_id,book_id) VALUES (10,8);
