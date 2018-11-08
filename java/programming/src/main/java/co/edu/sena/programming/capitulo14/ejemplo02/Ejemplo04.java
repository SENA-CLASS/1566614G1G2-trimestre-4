package co.edu.sena.programming.capitulo14.ejemplo02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejemplo04 {
    public static void main(String[] args) throws SQLException{
        String url = "jdbc:mysql://localhost:4306?database=observador_de_proyectos";
        String usuarioBaseDatos = "pepito";
        String passwordDatabase = "123456789";

        Connection conexion = null;
        PreparedStatement sentencia = null;

        String sql = "UPDATE `observador_de_proyectos`.`cliente`\n" +
                "SET\n" +
                "`primer_nombre` = ?\n" +
                "WHERE `tipo_documento` = ? AND `numero_documento` = ?;";

        try {
            conexion = DriverManager.getConnection(url, usuarioBaseDatos, passwordDatabase);
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, "pedrito");
            sentencia.setString(2, "CC");
            sentencia.setString(3, "88888");



            int rs = sentencia.executeUpdate();
            System.out.println(rs);


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
