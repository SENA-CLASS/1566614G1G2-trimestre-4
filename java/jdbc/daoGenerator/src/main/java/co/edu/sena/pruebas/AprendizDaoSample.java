

package co.edu.sena.pruebas;

import java.math.*;
import java.util.Date;
import java.util.Collection;
import co.edu.sena.controller.dao.AprendizDao;
import co.edu.sena.model.dao.dto.Aprendiz;
import co.edu.sena.controller.dao.exceptions.AprendizDaoException;
import co.edu.sena.controller.factory.AprendizDaoFactory;

public class AprendizDaoSample
{
	/**
	 * Method 'main'
	 * 
	 * @param arg
	 * @throws Exception
	 */
	public static void main(String[] arg) throws Exception
	{
		// Uncomment one of the lines below to test the generated code
		
		 findAll();
		// findByEstadoFormacion("");
		// findByGrupoProyecto("", 0);
		// findByCliente("", "");
		// findWhereTipoDocumentoEquals("");
		// findWhereNumeroDocumentoEquals("");
		// findWhereEstadoEquals("");
		// findWhereFichaEquals("");
		// findWhereGrupoCodigoEquals(0);
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			AprendizDao _dao = getAprendizDao();
			Aprendiz _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByEstadoFormacion'
	 * 
	 * @param estado
	 */
	public static void findByEstadoFormacion(String estado)
	{
		try {
			AprendizDao _dao = getAprendizDao();
			Aprendiz _result[] = _dao.findByEstadoFormacion(estado);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByGrupoProyecto'
	 * 
	 * @param ficha
	 * @param grupoCodigo
	 */
	public static void findByGrupoProyecto(String ficha, int grupoCodigo)
	{
		try {
			AprendizDao _dao = getAprendizDao();
			Aprendiz _result[] = _dao.findByGrupoProyecto(ficha, grupoCodigo);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByCliente'
	 * 
	 * @param tipoDocumento
	 * @param numeroDocumento
	 */
	public static void findByCliente(String tipoDocumento, String numeroDocumento)
	{
		try {
			AprendizDao _dao = getAprendizDao();
			Aprendiz _result[] = _dao.findByCliente(tipoDocumento, numeroDocumento);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereTipoDocumentoEquals'
	 * 
	 * @param tipoDocumento
	 */
	public static void findWhereTipoDocumentoEquals(String tipoDocumento)
	{
		try {
			AprendizDao _dao = getAprendizDao();
			Aprendiz _result[] = _dao.findWhereTipoDocumentoEquals(tipoDocumento);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereNumeroDocumentoEquals'
	 * 
	 * @param numeroDocumento
	 */
	public static void findWhereNumeroDocumentoEquals(String numeroDocumento)
	{
		try {
			AprendizDao _dao = getAprendizDao();
			Aprendiz _result[] = _dao.findWhereNumeroDocumentoEquals(numeroDocumento);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereEstadoEquals'
	 * 
	 * @param estado
	 */
	public static void findWhereEstadoEquals(String estado)
	{
		try {
			AprendizDao _dao = getAprendizDao();
			Aprendiz _result[] = _dao.findWhereEstadoEquals(estado);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereFichaEquals'
	 * 
	 * @param ficha
	 */
	public static void findWhereFichaEquals(String ficha)
	{
		try {
			AprendizDao _dao = getAprendizDao();
			Aprendiz _result[] = _dao.findWhereFichaEquals(ficha);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereGrupoCodigoEquals'
	 * 
	 * @param grupoCodigo
	 */
	public static void findWhereGrupoCodigoEquals(int grupoCodigo)
	{
		try {
			AprendizDao _dao = getAprendizDao();
			Aprendiz _result[] = _dao.findWhereGrupoCodigoEquals(grupoCodigo);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getAprendizDao'
	 * 
	 * @return AprendizDao
	 */
	public static AprendizDao getAprendizDao()
	{
		return AprendizDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(Aprendiz dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getTipoDocumento() );
		buf.append( ", " );
		buf.append( dto.getNumeroDocumento() );
		buf.append( ", " );
		buf.append( dto.getEstado() );
		buf.append( ", " );
		buf.append( dto.getFicha() );
		buf.append( ", " );
		buf.append( dto.getGrupoCodigo() );
		System.out.println( buf.toString() );
	}

}
