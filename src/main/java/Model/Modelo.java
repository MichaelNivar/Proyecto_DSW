/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class Modelo {

    private Connection connection;

    public static String url = "jdbc:mysql://localhost:3306/dws";
    private static String usuario = "root";
    private static String contra = "";
    public static Connection con;

    public Modelo() {
        try {
            connection = DriverManager.getConnection(url, usuario, contra);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
