package co.edu.sena.programming.capitulo14.ejemplo02;

import java.sql.*;

public class Ejemplo02 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:4306?database=observador_de_proyectos";
        String usuarioBaseDatos = "pepito";
        String passwordDatabase = "123456789";

        Connection conexion = null;
        PreparedStatement sentencia = null;

        String sql = "SELECT * FROM observador_de_proyectos.cliente WHERE tipo_documento=? AND numero_documento=?;";

        try {
            conexion = DriverManager.getConnection(url, usuarioBaseDatos, passwordDatabase);
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, "CC");
            sentencia.setString(2, "80013833");

            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
                System.out.println(rs.getString(6));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (sentencia != null)
                sentencia.close();
            if (conexion != null) {
                conexion.close();
            }
        }


    }


}
