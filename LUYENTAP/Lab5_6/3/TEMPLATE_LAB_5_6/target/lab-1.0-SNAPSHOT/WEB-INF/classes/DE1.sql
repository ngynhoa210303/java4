CREATE DATABASE Lab5_6_3;

USE Lab5_6_3;

CREATE TABLE thuc_vat (
	id BIGINT IDENTITY NOT NULL,
	loai varchar(100) NULL,
	ten varchar(100) NULL,
	tuoi varchar(100) NULL,
	gioiTinh BIT NULL,
	khuVuc varchar(100) NULL,
	CONSTRAINT thuc_vat_PK PRIMARY KEY (id)
)