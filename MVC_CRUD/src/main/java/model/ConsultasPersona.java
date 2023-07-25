package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public boolean buscar(Persona persona) {
        Connection conexion = getConnection();

        try {
            ps = conexion.prepareStatement("SELECT * FROM personas WHERE clave = ?");
            ps.setString(1, persona.getClave());

            rs = ps.executeQuery();

            if (rs.next()) {
                persona.setIdPersona(rs.getInt("id_persona"));
                persona.setClave(rs.getString("clave"));
                persona.setNombre(rs.getString("nombre"));
                persona.setDomicilio(rs.getString("domicilio"));
                persona.setCelular(rs.getString("celular"));
                persona.setCorreo(rs.getString("correo"));
                persona.setFechaNacimiento(Date.valueOf(rs.getString("fecha_nacimiento")));
                persona.setGenero(rs.getString("genero"));
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Error en query, " + ex);
        } finally {
            try {
                conexion.close();
                
            } catch (Exception e) {
                System.out.println("Error cerrando conexión, " + e);
            }
        }
        return false;
    }
    
    public boolean modificar(Persona persona) {
        Connection conexion = getConnection();

        try {
            ps = conexion.prepareStatement("UPDATE personas SET clave=?, nombre=?, domicilio=?, celular=?, correo=?, fecha_nacimiento=?, genero=? WHERE id_persona=?;");
            ps.setString(1, persona.getClave());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getDomicilio());
            ps.setString(4, persona.getCelular());
            ps.setString(5, persona.getCorreo());
            ps.setDate(6, persona.getFechaNacimiento());
            ps.setString(7, persona.getGenero());
            ps.setInt(8, persona.getIdPersona());

            int result = ps.executeUpdate();
            System.out.println(result);
            
            return result > 0;
            
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
    
    public boolean eliminar(Persona persona) {
        Connection conexion = getConnection();

        try {
            ps = conexion.prepareStatement("DELETE FROM personas WHERE id_persona = ?");
            ps.setString(1, String.valueOf(persona.getIdPersona()));

            int result = ps.executeUpdate();

            return result > 0;
            
        } catch (SQLException ex) {
            System.out.println("Error en query, " + ex);
        } finally {
            try {
                conexion.close();
                
            } catch (Exception e) {
                System.out.println("Error cerrando conexión, " + e);
            }
        }
        return false;
    }
}
