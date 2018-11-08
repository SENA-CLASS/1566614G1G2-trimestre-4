package co.edu.sena.programming.capitulo14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejemplo02 {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            String url = "jdbc:mysql://localhost:3306/senaceet?user=root&password=123456789";
            conexion = DriverManager.getConnection(url);
            if (conexion != null) {
                System.out.println("conexion a base de datos establicida");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException e) {
                System.out.println("closed error conection: " + e.getMessage());
            }
        }
    }
}
