USE [QUORA]
GO

/****** Object:  StoredProcedure [dbo].[ACTUALIZADATOS]    Script Date: 05/12/2019 18:27:24 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[ACTUALIZADATOS]
AS
	 DECLARE @UPDATECNSREQ VARCHAR(30)
	  DECLARE @UPDATEIDCNSREQ INT	
	  DECLARE @UPDATECNSRQDT VARCHAR(30)


	    SELECT MIN(REQUISICIONES.CNSREQ), MIN(REQUISICIONES.ID), MIN(REQUISICIONESDT.CNSRQDT), MIN(REQUISICIONESDT.ID) FROM REQUISICIONES
			   INNER JOIN REQUISICIONESDT ON
			   REQUISICIONES.CNSRQDT = REQUISICIONESDT.CNSRQDT
			   WHERE REQUISICIONESDT.CNSREQ IS NULL AND REQUISICIONESDT.IDREQ IS NULL
			  HAVING MIN( REQUISICIONESDT.CNSRQDT) = MIN( REQUISICIONES.CNSRQDT )

			SET @UPDATECNSREQ =(SELECT MIN(REQUISICIONES.CNSREQ)  FROM REQUISICIONES
			   INNER JOIN REQUISICIONESDT ON
			   REQUISICIONES.CNSRQDT = REQUISICIONESDT.CNSRQDT
			   WHERE REQUISICIONESDT.CNSREQ IS NULL AND REQUISICIONESDT.IDREQ IS NULL
			  HAVING MIN( REQUISICIONESDT.CNSRQDT) = MIN( REQUISICIONES.CNSRQDT ))
					
				SET @UPDATEIDCNSREQ =(SELECT  MIN (REQUISICIONES.ID) FROM REQUISICIONES
				 INNER JOIN REQUISICIONESDT ON
				 REQUISICIONES.CNSRQDT = REQUISICIONESDT.CNSRQDT
				  WHERE REQUISICIONESDT.CNSREQ IS NULL AND REQUISICIONESDT.IDREQ IS NULL
				 HAVING MIN( REQUISICIONESDT.CNSRQDT) = MIN( REQUISICIONES.CNSRQDT ))
	        
				SET @UPDATECNSRQDT =(SELECT  MIN(REQUISICIONESDT.CNSRQDT)  FROM REQUISICIONES
				  INNER JOIN REQUISICIONESDT ON
				  REQUISICIONES.CNSRQDT = REQUISICIONESDT.CNSRQDT
				 WHERE REQUISICIONESDT.CNSREQ IS NULL AND REQUISICIONESDT.IDREQ IS NULL
				 HAVING MIN( REQUISICIONESDT.CNSRQDT) = MIN( REQUISICIONES.CNSRQDT ))

	            UPDATE  REQUISICIONESDT SET  REQUISICIONESDT.CNSREQ =@UPDATECNSREQ,  REQUISICIONESDT.IDREQ=@UPDATEIDCNSREQ
				    FROM REQUISICIONESDT INNER JOIN REQUISICIONES
					 ON  REQUISICIONES.CNSRQDT = REQUISICIONESDT.CNSRQDT AND REQUISICIONESDT.ID = REQUISICIONES.IDRQDT
					 WHERE REQUISICIONESDT.CNSRQDT = @UPDATECNSRQDT 

GO


