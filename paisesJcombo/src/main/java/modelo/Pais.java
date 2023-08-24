package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class Pais {

    int idPais;
    String nombrePais;

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int id) {
        this.idPais = id;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombre) {
        this.nombrePais = nombre;
    }

    public Vector<Pais> mostrarPaises() {
        // Creando el valor por defecto del JComboBox (hardcode)
        Pais paisPorDefecto = new Pais();
        paisPorDefecto.setIdPais(0);
        paisPorDefecto.setNombrePais("Selecciona un país");

        // Creando el vector que usaremos para el JComboBox y agregando el valod por defecto en la posición 0 del vector;
        Vector vectorPaises = new Vector();
        vectorPaises.add(paisPorDefecto);

        // Creando conexion con la base de datos
        ConexionFactory con = new ConexionFactory();
        Connection connection = con.getConnection();

        // Iniciando interacción con la base de datos
        try {
            PreparedStatement ps = connection.prepareStatement("select * from paises;");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pais pais = new Pais();
                pais.setIdPais(rs.getInt("pais_id"));
                pais.setNombrePais(rs.getString("nombre_pais"));
                vectorPaises.add(pais);
            }

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return vectorPaises;
    }

    @Override
    public String toString() {
        return this.nombrePais;
    }

}
