CREATE TABLE cake ( 
   id BIGINT NOT NULL, 
   description VARCHAR(100) NOT NULL, 
   image VARCHAR(300) NOT NULL, 
   title VARCHAR(100) NOT NULL 
);

CREATE SEQUENCE cake_sequence INCREMENT BY 1; 