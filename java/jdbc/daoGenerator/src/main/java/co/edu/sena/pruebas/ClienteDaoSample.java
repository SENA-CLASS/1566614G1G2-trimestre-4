

package co.edu.sena.pruebas;

import java.math.*;
import java.util.Date;
import java.util.Collection;
import co.edu.sena.controller.dao.ClienteDao;
import co.edu.sena.model.dao.dto.Cliente;
import co.edu.sena.controller.dao.exceptions.ClienteDaoException;
import co.edu.sena.controller.factory.ClienteDaoFactory;

public class ClienteDaoSample
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
		// findByTipoDocumento("CC");
		// findWhereTipoDocumentoEquals("");
		// findWhereNumeroDocumentoEquals("");
		// findWherePrimerNombreEquals("");
		// findWhereSegundoNombreEquals("");
		// findWherePrimerApellidoEquals("");
		// findWhereSegundoApellidoEquals("");
		// findWhereFotoEquals(null);
	}

	/**
	 * Method 'findAll'
	 * 
	 */
	public static void findAll()
	{
		try {
			ClienteDao _dao = getClienteDao();
			Cliente _result[] = _dao.findAll();
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findByTipoDocumento'
	 * 
	 * @param tipoDocumento
	 */
	public static void findByTipoDocumento(String tipoDocumento)
	{
		try {
			ClienteDao _dao = getClienteDao();
			Cliente _result[] = _dao.findByTipoDocumento(tipoDocumento);
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
			ClienteDao _dao = getClienteDao();
			Cliente _result[] = _dao.findWhereTipoDocumentoEquals(tipoDocumento);
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
			ClienteDao _dao = getClienteDao();
			Cliente _result[] = _dao.findWhereNumeroDocumentoEquals(numeroDocumento);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWherePrimerNombreEquals'
	 * 
	 * @param primerNombre
	 */
	public static void findWherePrimerNombreEquals(String primerNombre)
	{
		try {
			ClienteDao _dao = getClienteDao();
			Cliente _result[] = _dao.findWherePrimerNombreEquals(primerNombre);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereSegundoNombreEquals'
	 * 
	 * @param segundoNombre
	 */
	public static void findWhereSegundoNombreEquals(String segundoNombre)
	{
		try {
			ClienteDao _dao = getClienteDao();
			Cliente _result[] = _dao.findWhereSegundoNombreEquals(segundoNombre);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWherePrimerApellidoEquals'
	 * 
	 * @param primerApellido
	 */
	public static void findWherePrimerApellidoEquals(String primerApellido)
	{
		try {
			ClienteDao _dao = getClienteDao();
			Cliente _result[] = _dao.findWherePrimerApellidoEquals(primerApellido);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereSegundoApellidoEquals'
	 * 
	 * @param segundoApellido
	 */
	public static void findWhereSegundoApellidoEquals(String segundoApellido)
	{
		try {
			ClienteDao _dao = getClienteDao();
			Cliente _result[] = _dao.findWhereSegundoApellidoEquals(segundoApellido);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'findWhereFotoEquals'
	 * 
	 * @param foto
	 */
	public static void findWhereFotoEquals(byte[] foto)
	{
		try {
			ClienteDao _dao = getClienteDao();
			Cliente _result[] = _dao.findWhereFotoEquals(foto);
			for (int i=0; i<_result.length; i++ ) {
				display( _result[i] );
			}
		
		}
		catch (Exception _e) {
			_e.printStackTrace();
		}
		
	}

	/**
	 * Method 'getClienteDao'
	 * 
	 * @return ClienteDao
	 */
	public static ClienteDao getClienteDao()
	{
		return ClienteDaoFactory.create();
	}

	/**
	 * Method 'display'
	 * 
	 * @param dto
	 */
	public static void display(Cliente dto)
	{
		StringBuffer buf = new StringBuffer();
		buf.append( dto.getTipoDocumento() );
		buf.append( ", " );
		buf.append( dto.getNumeroDocumento() );
		buf.append( ", " );
		buf.append( dto.getPrimerNombre() );
		buf.append( ", " );
		buf.append( dto.getSegundoNombre() );
		buf.append( ", " );
		buf.append( dto.getPrimerApellido() );
		buf.append( ", " );
		buf.append( dto.getSegundoApellido() );
		buf.append( ", " );
		buf.append( dto.getFoto() );
		System.out.println( buf.toString() );
	}

}
