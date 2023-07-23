package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConsultasPersona extends Conexion {

    private PreparedStatement ps;
    private ResultSet rs;

    public boolean insertar(Persona persona) {
        Connection conexion = getConnection();

        try {
            ps = conexion.prepareStatement("INSERT INTO personas (clave,nombre,domicilio,celular,correo,fecha_nacimiento,genero) VALUES (?,?,?,?,?,?,?);");
            ps.setString(1, persona.getClave());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getDomicilio());
            ps.setString(4, persona.getCelular());
            ps.setString(5, persona.getCorreo());
            ps.setDate(6, persona.getFechaNacimiento());
            ps.setString(7, persona.getGenero());

            int result = ps.executeUpdate();

            if (result > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error, " + ex);
        } finally {
            try {
                conexion.close();
            } catch (Exception e) {
                System.out.println("Error, " + e);
            }
        }
        return false;
    }

}
