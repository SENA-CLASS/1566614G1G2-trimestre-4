package co.edu.sena.programming.capitulo14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Ejemplo03 {
    public static void main(String[] args) {
        Connection conexion = null;
        try {
            String url = "jdbc:mysql://localhost:3306/senaceet";
            Properties info = new Properties();
            info.setProperty("user", "root");
            info.setProperty("password", "123456789");
            //Class.forName("dirver.") ya no se usa desde la version jdbc 4.0
            conexion = DriverManager.getConnection(url, info);
            if (conexion != null) {
                System.out.println("conexión a base de datos establecida");
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
