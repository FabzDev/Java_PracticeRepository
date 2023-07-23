package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Modelo;
import view.Vista;


public class Controlador implements ActionListener{
    Vista vista;
    Modelo modelo;

    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        vista.btnSumar.addActionListener(this);
    }

    public void iniciar(){
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        modelo.setNumero1(Integer.parseInt(vista.txtNumero1.getText()));
        modelo.setNumero2(Integer.parseInt(vista.txtNumero2.getText()));
        vista.txtResultado.setText(String.valueOf(modelo.suma()));
    }
}
