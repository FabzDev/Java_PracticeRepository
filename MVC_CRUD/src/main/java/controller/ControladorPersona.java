
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import model.ConsultasPersona;
import model.Persona;
import view.Formato;

public class ControladorPersona implements ActionListener{
    
    private Formato vista;
    private Persona persona;
    private ConsultasPersona modelo;

    public ControladorPersona(Formato vista, Persona persona, ConsultasPersona modelo) {
        this.vista = vista;
        this.persona = persona;
        this.modelo = modelo;
        vista.btnInsertar.addActionListener(this);
        vista.btnModificar.addActionListener(this);
    }
    
    public void llenarPersona(){
        this.persona.setClave(vista.txtId.getText());
        this.persona.setNombre(vista.txtNombre.getText());
        this.persona.setDomicilio(vista.txtDomicilio.getText());
        this.persona.setCelular(vista.txtCelular.getText());
        this.persona.setCorreo(vista.txtCorreo.getText());
        this.persona.setFechaNacimiento(Date.valueOf(vista.txtFechaNacimiento.getText()));
        this.persona.setGenero((String)vista.comboGenero.getSelectedItem());
    }
    
    public void iniciarControlador(){
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setTitle("CRUD MVC");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Insertar")){
            llenarPersona();
            if(modelo.insertar(persona)){
                JOptionPane.showInternalMessageDialog(null, "Registro insertado con exito");
            }else {
                JOptionPane.showInternalMessageDialog(null, "Error al insertar registro");
            }
        }
    }
    
    
    
    
}
