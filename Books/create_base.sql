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

INSERT INTO authors (surname,firstname) VALUES ('������','����');
INSERT INTO authors (surname,firstname) VALUES ('������','����');
INSERT INTO authors (surname,firstname) VALUES ('�������','������');
INSERT INTO authors (surname,firstname) VALUES ('�������','�����');
INSERT INTO authors (surname,firstname) VALUES ('��������','���������');
INSERT INTO authors (surname,firstname) VALUES ('���������','������');
INSERT INTO authors (surname,firstname) VALUES ('����������','����');
INSERT INTO authors (surname,firstname) VALUES ('��������','�������');
INSERT INTO authors (surname,firstname) VALUES ('���������','�����');
INSERT INTO authors (surname,firstname) VALUES ('������','�����');

INSERT INTO books (title,page_count) VALUES ('����',120);
INSERT INTO books (title,page_count) VALUES ('����',215);
INSERT INTO books (title,page_count) VALUES ('�����������',56);
INSERT INTO books (title,page_count) VALUES ('��������� �����',198);
INSERT INTO books (title,page_count) VALUES ('����',76);
INSERT INTO books (title,page_count) VALUES ('����',244);
INSERT INTO books (title,page_count) VALUES ('�������� ���',96);
INSERT INTO books (title,page_count) VALUES ('����� �����',88);
INSERT INTO books (title,page_count) VALUES ('�����',147);
INSERT INTO books (title,page_count) VALUES ('�����',112);

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


