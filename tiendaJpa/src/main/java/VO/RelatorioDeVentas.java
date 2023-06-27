package VO;

import java.time.LocalDate;

public class RelatorioDeVentas {
    private String nombre;
    private Long cantidad;
    private LocalDate date;

    public RelatorioDeVentas(String nombre, Long cantidad, LocalDate date) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.date = date;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RelatorioVentasVO{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", date=" + date +
                '}';
    }
}
