
CREATE PROCEDURE DELETETABLEABRIL
AS
DROP TABLE IF EXISTS dbo.ABRIL

CREATE TABLE ABRIL
(
ID INT IDENTITY(1,1) NOT NULL,
CNSABR AS RIGHT ('CNSABR' + CAST (ID AS VARCHAR(20)),20) PERSISTED NOT NULL,
DIAABRIL VARCHAR(30) NULL,
CONSTRAINT PK_ABRILD PRIMARY KEY CLUSTERED(ID,CNSABR)
)


GO

EXEC DELETETABLEABRIL