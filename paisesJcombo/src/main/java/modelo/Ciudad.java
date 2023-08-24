package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class Ciudad {

    int idCiudad;
    String nombreCiudad;
    int idsEstado;

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public int getIdsEstado() {
        return idsEstado;
    }

    public void setIdsEstado(int idsEstado) {
        this.idsEstado = idsEstado;
    }

    public Vector<Ciudad> mostrarCiudades(int idEstado) {
        // Creando el vector que usaremos para el JComboBox
        Vector vectorCiudades = new Vector();

        // Creando conexion con la base de datos
        ConexionFactory con = new ConexionFactory();
        Connection connection = con.getConnection();

        // Iniciando interacción con la base de datos
        try {
            PreparedStatement ps = connection.prepareStatement("select * from ciudades where estado_id=?;");
            ps.setInt(1, idEstado);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Ciudad ciudad = new Ciudad();
                ciudad.setIdCiudad(rs.getInt("ciudad_id"));
                ciudad.setNombreCiudad(rs.getString("nombre_ciudad"));
                ciudad.setIdCiudad(rs.getInt("estado_id"));

                vectorCiudades.add(ciudad);
            }

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return vectorCiudades;
    }
    
    @Override
    public String toString() {
        return nombreCiudad;
    }

}
