package co.edu.sena.ejemplodao.controller.dao.mysql;

import co.edu.sena.ejemplodao.controller.dao.TipoDocumentoDAO;
import co.edu.sena.ejemplodao.controller.dao.util.ResourceManager;
import co.edu.sena.ejemplodao.modelo.dto.ClienteDTO;
import co.edu.sena.ejemplodao.modelo.dto.TipoDocumentoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MysqlTipoDocumentoDAO implements TipoDocumentoDAO {

    private Connection conexion;

    @Override
    public int insert(TipoDocumentoDTO tipoDocumentoDTO) {
        int cambios=0;
        String sql = "INSERT INTO " +getTableName()+
                "(documento,\n" +
                "descripcion,\n" +
                "estado)\n" +
                "VALUES\n" +
                "(?,?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1,tipoDocumentoDTO.getDocumento());
            sentencia.setString(2,tipoDocumentoDTO.getDescripcion());
            sentencia.setBoolean(3,tipoDocumentoDTO.getEstado());

            cambios= sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return cambios;
    }

    private String getTableName() {
        return "tipo_documento ";
    }

    @Override
    public int update(TipoDocumentoDTO tipoDocumentoDTO, String primaryKey) {
        int cambios=0;
        String sql = "UPDATE " +getTableName()+
                "SET " +
                "documento = ?, " +
                "descripcion = ?, " +
                "estado = ? " +
                "WHERE documento = ?;";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1,tipoDocumentoDTO.getDocumento());
            sentencia.setString(2,tipoDocumentoDTO.getDescripcion());
            sentencia.setBoolean(3,tipoDocumentoDTO.getEstado());
            sentencia.setString(4,primaryKey);
            cambios=sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return cambios;
    }

    @Override
    public int delete(String primaryKey) {
        int cambios=0;
        String sql = "DELETE FROM tipo_documento WHERE documento =?;";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, primaryKey);
            cambios=sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return cambios;

    }

    @Override
    public Collection<TipoDocumentoDTO> findAll() {
        String sql = "SELECT documento,\n" +
                "    descripcion,\n" +
                "    estado\n" +
                "FROM "+getTableName()+";";
        List<TipoDocumentoDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    TipoDocumentoDTO ct = new TipoDocumentoDTO();
                    ct.setDocumento(rs.getString(1));
                    ct.setDescripcion(rs.getString(2));
                    ct.setEstado(rs.getBoolean(3));
                    resultado.add(ct);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(rs);
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return resultado;
    }

    @Override
    public TipoDocumentoDTO findPk(String primaryKey) {
        String sql = "SELECT documento,\n" +
                "    descripcion,\n" +
                "    estado\n" +
                "FROM "+getTableName()+" where documento = ? ;";
        TipoDocumentoDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1,primaryKey);
            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new TipoDocumentoDTO();
                    resultado.setDocumento(rs.getString(1));
                    resultado.setDescripcion(rs.getString(2));
                    resultado.setEstado(rs.getBoolean(3));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(rs);
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return resultado;
    }
}
