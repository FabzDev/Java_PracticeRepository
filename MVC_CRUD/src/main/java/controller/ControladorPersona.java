package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JOptionPane;
import model.ConsultasPersona;
import model.Persona;
import view.Formato;

public class ControladorPersona implements ActionListener {

    private Formato vista;
    private Persona persona;
    private ConsultasPersona modelo;

    public ControladorPersona(Formato vista, Persona persona, ConsultasPersona modelo) {
        this.vista = vista;
        this.persona = persona;
        this.modelo = modelo;
        vista.btnInsertar.addActionListener(this);
        vista.btnLimpiar.addActionListener(this);
        vista.btnBuscarId.addActionListener(this);
        vista.btnModificar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
    }

    public void iniciarControlador() {
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setTitle("CRUD MVC");
    }

    public void limpiarFormato() {
        vista.txtHiddenId.setText(null);
        vista.txtBuscar.setText(null);
        vista.txtId.setText(null);
        vista.txtNombre.setText(null);
        vista.txtDomicilio.setText(null);
        vista.txtCelular.setText(null);
        vista.txtCorreo.setText(null);
        vista.txtFechaNacimiento.setText(null);
        vista.comboGenero.setSelectedIndex(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Insertar")) {

            this.persona.setClave(vista.txtId.getText());
            this.persona.setNombre(vista.txtNombre.getText());
            this.persona.setDomicilio(vista.txtDomicilio.getText());
            this.persona.setCelular(vista.txtCelular.getText());
            this.persona.setCorreo(vista.txtCorreo.getText());
            this.persona.setFechaNacimiento(Date.valueOf(vista.txtFechaNacimiento.getText()));
            this.persona.setGenero((String) vista.comboGenero.getSelectedItem());

            if (modelo.insertar(persona)) {
                JOptionPane.showInternalMessageDialog(null, "Registro insertado con exito");
            } else {
                JOptionPane.showInternalMessageDialog(null, "Error al insertar registro");
            }
            limpiarFormato();
        }

        if (e.getActionCommand().equals("Limpiar")) {
            limpiarFormato();
            System.out.println(e);
        }

        if (e.getActionCommand().equals("Buscar ID")) {
            this.persona.setClave(vista.txtBuscar.getText());

            if (modelo.buscar(persona)) {
                vista.txtHiddenId.setText(String.valueOf(this.persona.getIdPersona()));
                vista.txtId.setText(this.persona.getClave());
                vista.txtNombre.setText(this.persona.getNombre());
                vista.txtDomicilio.setText(this.persona.getDomicilio());
                vista.txtCelular.setText(this.persona.getCelular());
                vista.txtCorreo.setText(this.persona.getCorreo());
                vista.txtFechaNacimiento.setText(String.valueOf(this.persona.getFechaNacimiento()));
                vista.comboGenero.setSelectedItem(this.persona.getGenero());

            } else {
                JOptionPane.showInternalMessageDialog(null, "Registro no encontrado");
                limpiarFormato();
            }
        }

        if (e.getSource().equals(vista.btnModificar)) {
            
            this.persona.setIdPersona(Integer.parseInt(vista.txtHiddenId.getText()));
            this.persona.setClave(vista.txtId.getText());
            this.persona.setNombre(vista.txtNombre.getText());
            this.persona.setDomicilio(vista.txtDomicilio.getText());
            this.persona.setCelular(vista.txtCelular.getText());
            this.persona.setCorreo(vista.txtCorreo.getText());
            this.persona.setFechaNacimiento(Date.valueOf(vista.txtFechaNacimiento.getText()));
            this.persona.setGenero((String) vista.comboGenero.getSelectedItem());
            
            if (modelo.modificar(persona)) {
                
                JOptionPane.showInternalMessageDialog(null, "Registro modificado con exito");
                limpiarFormato();
            } else {
                JOptionPane.showInternalMessageDialog(null, "Error al modificar registro");
            }
        }
        
        if (e.getSource().equals(vista.btnEliminar)) {
            
            if (modelo.eliminar(persona)) {
                
                JOptionPane.showInternalMessageDialog(null, "Registro eliminado con exito");
                limpiarFormato();
            } else {
                JOptionPane.showInternalMessageDialog(null, "Error al modificar registro");
            }
            
        }
    }
}
