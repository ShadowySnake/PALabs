DROP TABLE movies CASCADE CONSTRAINTS
/
DROP TABLE genres CASCADE CONSTRAINTS
/
DROP TABLE movie_genres CASCADE CONSTRAINTS
/
DROP TABLE movie_details CASCADE CONSTRAINTS
/
DROP TABLE persons CASCADE CONSTRAINTS
/
CREATE TABLE movies(
  id INT NOT NULL PRIMARY KEY,
  title VARCHAR2(256) NOT NULL,
  release_date DATE NOT NULL,
  duration INT NOT NULL,
  score INT NOT NULL
)
/
CREATE TABLE genres(
 id INT NOT NULL PRIMARY KEY,
 name VARCHAR2(256) NOT NULL
)
/
CREATE TABLE movie_genres(
  movie_id INT NOT NULL,
  genre_id INT NOT NULL,
  CONSTRAINT fk_mov_id FOREIGN KEY(movie_id) REFERENCES movies(id),
  CONSTRAINT fk_gen_id FOREIGN KEY(genre_id) REFERENCES genres(id)
)
/
CREATE TABLE movie_details(
  movie_id INT NOT NULL,
  genre_id INT NOT NULL,
  director_id INT NOT NULL,
  CONSTRAINT fk_movie_id FOREIGN KEY(movie_id) REFERENCES movies(id),
  CONSTRAINT fk_genre_id FOREIGN KEY(genre_id) REFERENCES genres(id),
  CONSTRAINT fk_director_id FOREIGN KEY(director_id) REFERENCES persons(id)
)
/
CREATE TABLE persons(
  id INT NOT NULL PRIMARY KEY,
  person_name VARCHAR2(256) NOT NULL,
  person_job VARCHAR2(20) NOT NULL,
  movie_starring INT
)
/