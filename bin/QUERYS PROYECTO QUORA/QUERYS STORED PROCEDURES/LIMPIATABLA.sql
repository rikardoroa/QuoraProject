USE [QUORA]
GO
/****** Object:  StoredProcedure [dbo].[LIMPIATABLA]    Script Date: 20/12/2019 21:20:06 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

	ALTER PROCEDURE [dbo].[LIMPIATABLA]
					AS
						DELETE FROM REQUISICIONESDT WHERE CNSREQ IS NULL AND IDREQ IS NULL

