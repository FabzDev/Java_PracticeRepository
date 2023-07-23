

import controller.Controlador;
import model.Modelo;
import view.Vista;

public class MVCsuma{
    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        Vista view = new Vista();
        Controlador controlador = new Controlador(view, modelo);
        view.setVisible(true);
    }
}
