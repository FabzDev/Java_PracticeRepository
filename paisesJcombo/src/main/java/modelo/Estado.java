package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class Estado {

    int idEstado;
    String nombreEstado;
    int idPais;

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public Vector<Estado> mostrarEstados(int idPais) {
        // Creando el vector que usaremos para el JComboBox
        Vector vectorEstados = new Vector();

        // Creando conexion con la base de datos
        ConexionFactory con = new ConexionFactory();
        Connection connection = con.getConnection();

        // Iniciando interacción con la base de datos
        try {
            PreparedStatement ps = connection.prepareStatement("select * from estados where pais_id=?;");
            ps.setInt(1, idPais);
            System.out.println(idPais);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Estado estado = new Estado();
                estado.setIdEstado(rs.getInt("estado_id"));
                estado.setNombreEstado(rs.getString("nombre_estado"));
                estado.setIdPais(rs.getInt("pais_id"));

                vectorEstados.add(estado);
            }

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return vectorEstados;
    }

    @Override
    public String toString() {
        return nombreEstado;
    }

}
