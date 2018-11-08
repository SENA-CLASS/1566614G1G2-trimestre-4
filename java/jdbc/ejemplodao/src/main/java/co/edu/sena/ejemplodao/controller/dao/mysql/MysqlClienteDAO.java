package co.edu.sena.ejemplodao.controller.dao.mysql;

import co.edu.sena.ejemplodao.controller.dao.ClienteDAO;
import co.edu.sena.ejemplodao.controller.dao.util.ResourceManager;
import co.edu.sena.ejemplodao.modelo.dto.ClienteDTO;
import co.edu.sena.ejemplodao.modelo.dto.ClientePkDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MysqlClienteDAO implements ClienteDAO {

    Connection conexion = null;

    @Override
    public int insert(ClienteDTO cliente) {
        int cambios=0;
        String sqlInsert = "INSERT INTO " + getTableName() +
                "(tipo_documento,\n" +
                "numero_documento,\n" +
                "primer_nombre,\n" +
                "segundo_nombre,\n" +
                "primer_apellido,\n" +
                "segundo_apellido\n" +
                ")\n" +
                "VALUES\n" +
                "(?,?,?,?,?,?);";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlInsert);
            sentencia.setString(1, cliente.getTipoDocumento());
            sentencia.setString(2, cliente.getNumeroDocumento());
            sentencia.setString(3, cliente.getPrimerNombre());
            sentencia.setString(4, cliente.getSegundoNombre());
            sentencia.setString(5, cliente.getPrimerApellido());
            sentencia.setString(6, cliente.getSegundoApellido());
            cambios= sentencia.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ResourceManager.close(sentencia);
            ResourceManager.close(conexion);
        }
        return cambios;
    }


    @Override
    public int update(ClienteDTO cliente, ClientePkDTO llavePrimaria) {
        int cambios=0;
        String sqlUpdate = "UPDATE " + getTableName() +
                " SET tipo_documento = ?, numero_documento = ?, primer_nombre = ?, segundo_nombre = ?, primer_apellido = ?, segundo_apellido = ? WHERE tipo_documento = ? AND numero_documento = ?";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sqlUpdate);
            sentencia.setString(1, cliente.getTipoDocumento());
            sentencia.setString(2, cliente.getNumeroDocumento());
            sentencia.setString(3, cliente.getPrimerNombre());
            sentencia.setString(4, cliente.getSegundoNombre());
            sentencia.setString(5, cliente.getPrimerApellido());
            sentencia.setString(6, cliente.getSegundoApellido());
            sentencia.setString(7, llavePrimaria.getTipoDocumento());
            sentencia.setString(8, llavePrimaria.getNumeroDocumento());
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
    public int delete(ClientePkDTO llave) {
        int cambios=0;
        String sql = "DELETE FROM " + getTableName() + " WHERE tipo_documento = ? AND numero_documento = ?";
        PreparedStatement sentencia = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llave.getTipoDocumento());
            sentencia.setString(2, llave.getNumeroDocumento());
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
    public Collection<ClienteDTO> findAll() {
        String sql = "SELECT tipo_documento, numero_documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, foto FROM " + getTableName() + "";
        List<ClienteDTO> resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            rs = sentencia.executeQuery();
            if (rs != null) {
                resultado = new ArrayList<>();
                while (rs.next()) {
                    ClienteDTO ct = new ClienteDTO();
                    ct.setTipoDocumento(rs.getString(1));
                    ct.setNumeroDocumento(rs.getString(2));
                    ct.setPrimerNombre(rs.getString(3));
                    ct.setSegundoNombre(rs.getString(4));
                    ct.setPrimerApellido(rs.getString(5));
                    ct.setSegundoApellido(rs.getString(6));
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
    public ClienteDTO findPk(ClientePkDTO llave) {
        String sql = "SELECT tipo_documento, numero_documento, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido FROM " + getTableName() + " where tipo_documento=? and numero_documento=?";
        ClienteDTO resultado = null;
        PreparedStatement sentencia = null;
        ResultSet rs = null;
        try {
            conexion = ResourceManager.getConnection();
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, llave.getTipoDocumento());
            sentencia.setString(2, llave.getNumeroDocumento());
            rs = sentencia.executeQuery();
            if (rs != null) {

                while (rs.next()) {
                    resultado = new ClienteDTO();
                    resultado.setTipoDocumento(rs.getString(1));
                    resultado.setNumeroDocumento(rs.getString(2));
                    resultado.setPrimerNombre(rs.getString(3));
                    resultado.setSegundoNombre(rs.getString(4));
                    resultado.setPrimerApellido(rs.getString(5));
                    resultado.setSegundoApellido(rs.getString(6));

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

    private String getTableName() {
        return "cliente ";
    }

}
