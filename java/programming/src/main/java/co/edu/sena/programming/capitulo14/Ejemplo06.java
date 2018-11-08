package co.edu.sena.programming.capitulo14;

import java.sql.*;

public class Ejemplo06 {
    public static void main(String[] args) {
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            String url = "jdbc:mysql://localhost:3306/observador_de_proyectos";
            String user = "root";
            String pass = "123456789";
            conexion = DriverManager.getConnection(url, user, pass);

            String query = "insert into tipo_documento values (?,?,?);";
            sentencia = conexion.prepareStatement(query);
            sentencia.setString(1, "Nit");
            sentencia.setString(2, "numero de indentificacion t");
            sentencia.setInt(3, 1);

            int resultado = sentencia.executeUpdate();
            if(resultado>0){
                System.out.println("se insertaron "+resultado+" registros");
            }else{
                System.out.println("no se inserto");
            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (sentencia != null)
                    sentencia.close();
                if (conexion != null)
                    conexion.close();
            } catch (SQLException e) {
                System.out.println("closed error conection: " + e.getMessage());
            }
        }

    }
}

