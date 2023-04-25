package com.alura.jdbc.pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {

    public static void main(String[] args) throws SQLException {
        Connection con1 = new ConectionFactory().methodConectionFactory("jdbc:mysql://localhost/control_de_stock?useTimeZone=true&serverTimeZone=UTC",
                "root",
                "faeavf44");
        
        System.out.println("Cerrando la conexión");

        con1.close();
    }

}
