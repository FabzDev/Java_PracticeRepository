



import controller.ControladorPersona;
import model.ConsultasPersona;
import model.Persona;
import view.Formato;

public class MVC_CRUD {

    public static void main(String[] args) {
        Formato vista = new Formato();
        Persona persona = new Persona();
        ConsultasPersona modelo = new ConsultasPersona();
        
        ControladorPersona controlador = new ControladorPersona(vista, persona, modelo);
        controlador.iniciarControlador();
        
        
    }
}
