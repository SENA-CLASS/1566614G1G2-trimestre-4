
package co.edu.sena.controller.dao.jdbc;

import co.edu.sena.controller.dao.*;
import co.edu.sena.controller.factory.*;
import co.edu.sena.model.dao.dto.*;
import co.edu.sena.controller.dao.exceptions.*;
import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ClienteDaoImpl extends AbstractDAO implements ClienteDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected Connection userConn;

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT tipo_documento, numero_documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, foto FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( tipo_documento, numero_documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, foto ) VALUES ( ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET tipo_documento = ?, numero_documento = ?, primer_nombre = ?, segundo_nombre = ?, primer_apellido = ?, segundo_apellido = ?, foto = ? WHERE tipo_documento = ? AND numero_documento = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE tipo_documento = ? AND numero_documento = ?";

	/** 
	 * Index of column tipo_documento
	 */
	protected static final int COLUMN_TIPO_DOCUMENTO = 1;

	/** 
	 * Index of column numero_documento
	 */
	protected static final int COLUMN_NUMERO_DOCUMENTO = 2;

	/** 
	 * Index of column primer_nombre
	 */
	protected static final int COLUMN_PRIMER_NOMBRE = 3;

	/** 
	 * Index of column segundo_nombre
	 */
	protected static final int COLUMN_SEGUNDO_NOMBRE = 4;

	/** 
	 * Index of column primer_apellido
	 */
	protected static final int COLUMN_PRIMER_APELLIDO = 5;

	/** 
	 * Index of column segundo_apellido
	 */
	protected static final int COLUMN_SEGUNDO_APELLIDO = 6;

	/** 
	 * Index of column foto
	 */
	protected static final int COLUMN_FOTO = 7;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 7;

	/** 
	 * Index of primary-key column tipo_documento
	 */
	protected static final int PK_COLUMN_TIPO_DOCUMENTO = 1;

	/** 
	 * Index of primary-key column numero_documento
	 */
	protected static final int PK_COLUMN_NUMERO_DOCUMENTO = 2;

	/** 
	 * Inserts a new row in the cliente table.
	 */
	public ClientePk insert(Cliente dto) throws ClienteDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_INSERT );
			int index = 1;
			stmt.setString( index++, dto.getTipoDocumento() );
			stmt.setString( index++, dto.getNumeroDocumento() );
			stmt.setString( index++, dto.getPrimerNombre() );
			stmt.setString( index++, dto.getSegundoNombre() );
			stmt.setString( index++, dto.getPrimerApellido() );
			stmt.setString( index++, dto.getSegundoApellido() );
			super.setBlobColumn(stmt, index++, dto.getFoto() );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ClienteDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the cliente table.
	 */
	public void update(ClientePk pk, Cliente dto) throws ClienteDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_UPDATE + " with DTO: " + dto );
			stmt = conn.prepareStatement( SQL_UPDATE );
			int index=1;
			stmt.setString( index++, dto.getTipoDocumento() );
			stmt.setString( index++, dto.getNumeroDocumento() );
			stmt.setString( index++, dto.getPrimerNombre() );
			stmt.setString( index++, dto.getSegundoNombre() );
			stmt.setString( index++, dto.getPrimerApellido() );
			stmt.setString( index++, dto.getSegundoApellido() );
			super.setBlobColumn(stmt, index++, dto.getFoto() );
			stmt.setString( 8, pk.getTipoDocumento() );
			stmt.setString( 9, pk.getNumeroDocumento() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ClienteDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the cliente table.
	 */
	public void delete(ClientePk pk) throws ClienteDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			System.out.println( "Executing " + SQL_DELETE + " with PK: " + pk );
			stmt = conn.prepareStatement( SQL_DELETE );
			stmt.setString( 1, pk.getTipoDocumento() );
			stmt.setString( 2, pk.getNumeroDocumento() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ClienteDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the cliente table that matches the specified primary-key value.
	 */
	public Cliente findByPrimaryKey(ClientePk pk) throws ClienteDaoException
	{
		return findByPrimaryKey( pk.getTipoDocumento(), pk.getNumeroDocumento() );
	}

	/** 
	 * Returns all rows from the cliente table that match the criteria 'tipo_documento = :tipoDocumento AND numero_documento = :numeroDocumento'.
	 */
	public Cliente findByPrimaryKey(String tipoDocumento, String numeroDocumento) throws ClienteDaoException
	{
		Cliente ret[] = findByDynamicSelect( SQL_SELECT + " WHERE tipo_documento = ? AND numero_documento = ?", new Object[] { tipoDocumento, numeroDocumento } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the cliente table that match the criteria ''.
	 */
	public Cliente[] findAll() throws ClienteDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY tipo_documento, numero_documento", null );
	}

	/** 
	 * Returns all rows from the cliente table that match the criteria 'tipo_documento = :tipoDocumento'.
	 */
	public Cliente[] findByTipoDocumento(String tipoDocumento) throws ClienteDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE tipo_documento = ?", new Object[] { tipoDocumento } );
	}

	/** 
	 * Returns all rows from the cliente table that match the criteria 'tipo_documento = :tipoDocumento'.
	 */
	public Cliente[] findWhereTipoDocumentoEquals(String tipoDocumento) throws ClienteDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE tipo_documento = ? ORDER BY tipo_documento", new Object[] { tipoDocumento } );
	}

	/** 
	 * Returns all rows from the cliente table that match the criteria 'numero_documento = :numeroDocumento'.
	 */
	public Cliente[] findWhereNumeroDocumentoEquals(String numeroDocumento) throws ClienteDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE numero_documento = ? ORDER BY numero_documento", new Object[] { numeroDocumento } );
	}

	/** 
	 * Returns all rows from the cliente table that match the criteria 'primer_nombre = :primerNombre'.
	 */
	public Cliente[] findWherePrimerNombreEquals(String primerNombre) throws ClienteDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE primer_nombre = ? ORDER BY primer_nombre", new Object[] { primerNombre } );
	}

	/** 
	 * Returns all rows from the cliente table that match the criteria 'segundo_nombre = :segundoNombre'.
	 */
	public Cliente[] findWhereSegundoNombreEquals(String segundoNombre) throws ClienteDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE segundo_nombre = ? ORDER BY segundo_nombre", new Object[] { segundoNombre } );
	}

	/** 
	 * Returns all rows from the cliente table that match the criteria 'primer_apellido = :primerApellido'.
	 */
	public Cliente[] findWherePrimerApellidoEquals(String primerApellido) throws ClienteDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE primer_apellido = ? ORDER BY primer_apellido", new Object[] { primerApellido } );
	}

	/** 
	 * Returns all rows from the cliente table that match the criteria 'segundo_apellido = :segundoApellido'.
	 */
	public Cliente[] findWhereSegundoApellidoEquals(String segundoApellido) throws ClienteDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE segundo_apellido = ? ORDER BY segundo_apellido", new Object[] { segundoApellido } );
	}

	/** 
	 * Returns all rows from the cliente table that match the criteria 'foto = :foto'.
	 */
	public Cliente[] findWhereFotoEquals(byte[] foto) throws ClienteDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE foto = ? ORDER BY foto", new Object[] { foto } );
	}

	/**
	 * Method 'ClienteDaoImpl'
	 * 
	 */
	public ClienteDaoImpl()
	{
	}

	/**
	 * Method 'ClienteDaoImpl'
	 * 
	 * @param userConn
	 */
	public ClienteDaoImpl(final Connection userConn)
	{
		this.userConn = userConn;
	}

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows)
	{
		this.maxRows = maxRows;
	}

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows()
	{
		return maxRows;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "observador_de_proyectos.cliente";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Cliente fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Cliente dto = new Cliente();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Cliente[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Cliente dto = new Cliente();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Cliente ret[] = new Cliente[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Cliente dto, ResultSet rs) throws SQLException
	{
		dto.setTipoDocumento( rs.getString( COLUMN_TIPO_DOCUMENTO ) );
		dto.setNumeroDocumento( rs.getString( COLUMN_NUMERO_DOCUMENTO ) );
		dto.setPrimerNombre( rs.getString( COLUMN_PRIMER_NOMBRE ) );
		dto.setSegundoNombre( rs.getString( COLUMN_SEGUNDO_NOMBRE ) );
		dto.setPrimerApellido( rs.getString( COLUMN_PRIMER_APELLIDO ) );
		dto.setSegundoApellido( rs.getString( COLUMN_SEGUNDO_APELLIDO ) );
		dto.setFoto( super.getBlobColumn(rs, COLUMN_FOTO ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Cliente dto)
	{
	}

	/** 
	 * Returns all rows from the cliente table that match the specified arbitrary SQL statement
	 */
	public Cliente[] findByDynamicSelect(String sql, Object[] sqlParams) throws ClienteDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ClienteDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns all rows from the cliente table that match the specified arbitrary SQL statement
	 */
	public Cliente[] findByDynamicWhere(String sql, Object[] sqlParams) throws ClienteDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = SQL_SELECT + " WHERE " + sql;
		
		
			System.out.println( "Executing " + SQL );
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ClienteDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

}
