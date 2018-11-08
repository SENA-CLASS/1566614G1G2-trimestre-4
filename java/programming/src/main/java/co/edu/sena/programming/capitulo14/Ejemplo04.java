package co.edu.sena.programming.capitulo14;

import java.sql.*;

public class Ejemplo04 {
    public static void main(String[] args) {
        Connection conexion = null;
        Statement sentencia = null;
        try {
            String url = "jdbc:mysql://localhost:3306/observador_de_proyectos";
            String user = "root";
            String pass = "123456789";
            conexion = DriverManager.getConnection(url, user, pass);

            sentencia = conexion.createStatement();
            String query = "select * from aprendiz";
            ResultSet resultado = sentencia.executeQuery(query);

            while(resultado.next()){
                System.out.print(resultado.getString("tipo_documento")+"\t");
                System.out.print(resultado.getString("numero_documento")+"\t");
                System.out.print(resultado.getString("estado")+"\t");
                System.out.print(resultado.getString("ficha")+"\t");
                System.out.print(resultado.getString("grupo_codigo")+"\t");

                System.out.println();
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
