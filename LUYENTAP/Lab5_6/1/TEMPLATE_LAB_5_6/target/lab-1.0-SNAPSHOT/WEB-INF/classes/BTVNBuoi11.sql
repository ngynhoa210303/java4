CREATE DATABASE BTVNBuoi11;

USE BTVNBuoi11;

CREATE TABLE sinh_vien (
	ma UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	ten VARCHAR(100) NULL,
	tuoi BIGINT NULL,
	dia_chi VARCHAR(100) NULL,
	gioi_tinh BIT NULL
)
select *from sinh_vien where ten=null or sinh_vien.gioi_tinh=1