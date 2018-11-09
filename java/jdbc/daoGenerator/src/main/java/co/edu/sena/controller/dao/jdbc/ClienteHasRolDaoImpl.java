
package co.edu.sena.controller.dao.jdbc;

import co.edu.sena.controller.dao.*;
import co.edu.sena.controller.factory.*;
import java.util.Date;
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

public class ClienteHasRolDaoImpl extends AbstractDAO implements ClienteHasRolDao
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
	protected final String SQL_SELECT = "SELECT tipo_documento, numero_documento, rol, estado, fecha_terminacion FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( tipo_documento, numero_documento, rol, estado, fecha_terminacion ) VALUES ( ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET tipo_documento = ?, numero_documento = ?, rol = ?, estado = ?, fecha_terminacion = ? WHERE tipo_documento = ? AND numero_documento = ? AND rol = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE tipo_documento = ? AND numero_documento = ? AND rol = ?";

	/** 
	 * Index of column tipo_documento
	 */
	protected static final int COLUMN_TIPO_DOCUMENTO = 1;

	/** 
	 * Index of column numero_documento
	 */
	protected static final int COLUMN_NUMERO_DOCUMENTO = 2;

	/** 
	 * Index of column rol
	 */
	protected static final int COLUMN_ROL = 3;

	/** 
	 * Index of column estado
	 */
	protected static final int COLUMN_ESTADO = 4;

	/** 
	 * Index of column fecha_terminacion
	 */
	protected static final int COLUMN_FECHA_TERMINACION = 5;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 5;

	/** 
	 * Index of primary-key column tipo_documento
	 */
	protected static final int PK_COLUMN_TIPO_DOCUMENTO = 1;

	/** 
	 * Index of primary-key column numero_documento
	 */
	protected static final int PK_COLUMN_NUMERO_DOCUMENTO = 2;

	/** 
	 * Index of primary-key column rol
	 */
	protected static final int PK_COLUMN_ROL = 3;

	/** 
	 * Inserts a new row in the cliente_has_rol table.
	 */
	public ClienteHasRolPk insert(ClienteHasRol dto) throws ClienteHasRolDaoException
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
			stmt.setString( index++, dto.getRol() );
			stmt.setShort( index++, dto.getEstado() );
			stmt.setDate(index++, dto.getFechaTerminacion()==null ? null : new java.sql.Date( dto.getFechaTerminacion().getTime() ) );
			System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ClienteHasRolDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the cliente_has_rol table.
	 */
	public void update(ClienteHasRolPk pk, ClienteHasRol dto) throws ClienteHasRolDaoException
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
			stmt.setString( index++, dto.getRol() );
			stmt.setShort( index++, dto.getEstado() );
			stmt.setDate(index++, dto.getFechaTerminacion()==null ? null : new java.sql.Date( dto.getFechaTerminacion().getTime() ) );
			stmt.setString( 6, pk.getTipoDocumento() );
			stmt.setString( 7, pk.getNumeroDocumento() );
			stmt.setString( 8, pk.getRol() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ClienteHasRolDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the cliente_has_rol table.
	 */
	public void delete(ClienteHasRolPk pk) throws ClienteHasRolDaoException
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
			stmt.setString( 3, pk.getRol() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ClienteHasRolDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the cliente_has_rol table that matches the specified primary-key value.
	 */
	public ClienteHasRol findByPrimaryKey(ClienteHasRolPk pk) throws ClienteHasRolDaoException
	{
		return findByPrimaryKey( pk.getTipoDocumento(), pk.getNumeroDocumento(), pk.getRol() );
	}

	/** 
	 * Returns all rows from the cliente_has_rol table that match the criteria 'tipo_documento = :tipoDocumento AND numero_documento = :numeroDocumento AND rol = :rol'.
	 */
	public ClienteHasRol findByPrimaryKey(String tipoDocumento, String numeroDocumento, String rol) throws ClienteHasRolDaoException
	{
		ClienteHasRol ret[] = findByDynamicSelect( SQL_SELECT + " WHERE tipo_documento = ? AND numero_documento = ? AND rol = ?", new Object[] { tipoDocumento, numeroDocumento, rol } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the cliente_has_rol table that match the criteria ''.
	 */
	public ClienteHasRol[] findAll() throws ClienteHasRolDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY tipo_documento, numero_documento, rol", null );
	}

	/** 
	 * Returns all rows from the cliente_has_rol table that match the criteria 'tipo_documento = :tipoDocumento AND numero_documento = :numeroDocumento'.
	 */
	public ClienteHasRol[] findByCliente(String tipoDocumento, String numeroDocumento) throws ClienteHasRolDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE tipo_documento = ? AND numero_documento = ?", new Object[] { tipoDocumento, numeroDocumento } );
	}

	/** 
	 * Returns all rows from the cliente_has_rol table that match the criteria 'rol = :rol'.
	 */
	public ClienteHasRol[] findByRol(String rol) throws ClienteHasRolDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE rol = ?", new Object[] { rol } );
	}

	/** 
	 * Returns all rows from the cliente_has_rol table that match the criteria 'tipo_documento = :tipoDocumento'.
	 */
	public ClienteHasRol[] findWhereTipoDocumentoEquals(String tipoDocumento) throws ClienteHasRolDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE tipo_documento = ? ORDER BY tipo_documento", new Object[] { tipoDocumento } );
	}

	/** 
	 * Returns all rows from the cliente_has_rol table that match the criteria 'numero_documento = :numeroDocumento'.
	 */
	public ClienteHasRol[] findWhereNumeroDocumentoEquals(String numeroDocumento) throws ClienteHasRolDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE numero_documento = ? ORDER BY numero_documento", new Object[] { numeroDocumento } );
	}

	/** 
	 * Returns all rows from the cliente_has_rol table that match the criteria 'rol = :rol'.
	 */
	public ClienteHasRol[] findWhereRolEquals(String rol) throws ClienteHasRolDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE rol = ? ORDER BY rol", new Object[] { rol } );
	}

	/** 
	 * Returns all rows from the cliente_has_rol table that match the criteria 'estado = :estado'.
	 */
	public ClienteHasRol[] findWhereEstadoEquals(short estado) throws ClienteHasRolDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE estado = ? ORDER BY estado", new Object[] {  new Short(estado) } );
	}

	/** 
	 * Returns all rows from the cliente_has_rol table that match the criteria 'fecha_terminacion = :fechaTerminacion'.
	 */
	public ClienteHasRol[] findWhereFechaTerminacionEquals(Date fechaTerminacion) throws ClienteHasRolDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE fecha_terminacion = ? ORDER BY fecha_terminacion", new Object[] { fechaTerminacion==null ? null : new java.sql.Date( fechaTerminacion.getTime() ) } );
	}

	/**
	 * Method 'ClienteHasRolDaoImpl'
	 * 
	 */
	public ClienteHasRolDaoImpl()
	{
	}

	/**
	 * Method 'ClienteHasRolDaoImpl'
	 * 
	 * @param userConn
	 */
	public ClienteHasRolDaoImpl(final Connection userConn)
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
		return "observador_de_proyectos.cliente_has_rol";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected ClienteHasRol fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			ClienteHasRol dto = new ClienteHasRol();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected ClienteHasRol[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			ClienteHasRol dto = new ClienteHasRol();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		ClienteHasRol ret[] = new ClienteHasRol[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(ClienteHasRol dto, ResultSet rs) throws SQLException
	{
		dto.setTipoDocumento( rs.getString( COLUMN_TIPO_DOCUMENTO ) );
		dto.setNumeroDocumento( rs.getString( COLUMN_NUMERO_DOCUMENTO ) );
		dto.setRol( rs.getString( COLUMN_ROL ) );
		dto.setEstado( rs.getShort( COLUMN_ESTADO ) );
		dto.setFechaTerminacion( rs.getDate(COLUMN_FECHA_TERMINACION ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(ClienteHasRol dto)
	{
	}

	/** 
	 * Returns all rows from the cliente_has_rol table that match the specified arbitrary SQL statement
	 */
	public ClienteHasRol[] findByDynamicSelect(String sql, Object[] sqlParams) throws ClienteHasRolDaoException
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
			throw new ClienteHasRolDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the cliente_has_rol table that match the specified arbitrary SQL statement
	 */
	public ClienteHasRol[] findByDynamicWhere(String sql, Object[] sqlParams) throws ClienteHasRolDaoException
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
			throw new ClienteHasRolDaoException( "Exception: " + _e.getMessage(), _e );
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
