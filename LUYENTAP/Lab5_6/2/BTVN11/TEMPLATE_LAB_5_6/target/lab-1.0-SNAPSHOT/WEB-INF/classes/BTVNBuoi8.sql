CREATE DATABASE BTVNBuoi8;

USE BTVNBuoi8;

CREATE TABLE BTVNBuoi8.san_pham (
	id BIGINT IDENTITY NOT NULL,
	ma varchar(100) NULL,
	ten varchar(100) NULL,
	loai varchar(100) NULL,
	gia FLOAT NULL,
	CONSTRAINT san_pham_PK PRIMARY KEY (id)
)