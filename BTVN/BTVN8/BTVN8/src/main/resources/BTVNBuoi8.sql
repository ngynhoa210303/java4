CREATE DATABASE BTVNBuoi7;

USE BTVNBuoi7;

CREATE TABLE giang_vien (
	mssv varchar(100) NOT NULL,
	ten varchar(100) NULL,
	tuoi BIGINT NULL,
	gioi_tinh BIT NULL,
	que_quan varchar(100) NULL,
	CONSTRAINT giang_vien_PK PRIMARY KEY (mssv)
)
Select* from giang_vien
INSERT INTO giang_vien VALUES('P1','HOANT',19,1,'THAI BINH');
INSERT INTO giang_vien VALUES('P2','HANGNT',20,1,'HA NOI');
INSERT INTO giang_vien VALUES('P3','HOAHOAOA',30,0,'THAI BINH');
INSERT INTO giang_vien VALUES('P4','ANHDT',19,0,'THAI NGUYEN');
INSERT INTO giang_vien VALUES('P5','ANHLT',20,1,'BINH DINH');
INSERT INTO giang_vien VALUES('P6','HANT',19,1,'THAI BINH');