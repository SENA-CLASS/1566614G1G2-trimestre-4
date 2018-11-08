package co.edu.sena.programming.capitulo14.ejemplo02;

import java.sql.*;

public class Ejemplo03 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:4306?database=observador_de_proyectos";
        String usuarioBaseDatos = "pepito";
        String passwordDatabase = "123456789";

        Connection conexion = null;
        PreparedStatement sentencia = null;

        String sql = "INSERT INTO `observador_de_proyectos`.`cliente`\n" +
                "(`tipo_documento`,\n" +
                "`numero_documento`,\n" +
                "`primer_nombre`,\n" +
                "`segundo_nombre`,\n" +
                "`primer_apellido`,\n" +
                "`segundo_apellido`\n" +
                ")\n" +
                "VALUES\n" +
                "(?,?,?,?,?,?);";

        try {
            conexion = DriverManager.getConnection(url, usuarioBaseDatos, passwordDatabase);
            sentencia = conexion.prepareStatement(sql);
            sentencia.setString(1, "CC");
            sentencia.setString(2, "88888");
            sentencia.setString(3, "sdfasd");
            sentencia.setString(4, "80013833");
            sentencia.setString(5, "80013833");
            sentencia.setString(6, "80013833");


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
