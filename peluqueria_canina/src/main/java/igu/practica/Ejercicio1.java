package igu.practica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio1 {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JButton button = new JButton();

    public Ejercicio1(){
        putFrame();
        putPanel();
        putLabel();
        putButton();
         }

    public void putFrame(){
        frame.setSize(new Dimension(500, 600)); // Definir tamaño de la ventana
        frame.setLocationRelativeTo(null); //Ubica la ventana en el centro de la pantalla
//        framePrincipal.setLocation(300, 500); // Definir la ubicación inicial de la ventana
//        framePrincipal.setBounds(300, 500, 500, 600); Define el tamaño y la posición en un mismo método
        frame.setTitle("Contador de clicks"); // Definir el título de la ventana
        frame.setVisible(true); // Definir la ventana como visible
        frame.setDefaultCloseOperation(3); // Definir cerrar la aplicación al cerrar la pantalla
        frame.setMinimumSize(new Dimension(500,500)); // Definir el tamaño minimo de la ventana
    }

    private void putPanel() {
        panel.setSize(frame.getWidth(), frame.getHeight());
        panel.setLayout(null);
//      panelPrincipal.setBackground(Color.CYAN);
        frame.add(panel);
    }

    private void putLabel(){
        label.setBounds(180, 150, 200, 30);
        label.setFont(new Font("Inter", 1, 18));
        label.setText("Pulsa el botón!");
        panel.add(label);
    }

    private void putButton() {
        button.setBounds(150, 350, 200, 30);
        button.setText("Pulsa Aqui");
        button.setFont(new Font("Inter", 1, 20));
        panel.add(button);

        ActionListener accionClick = new ActionListener() {
            int acum=0;
            @Override
            public void actionPerformed(ActionEvent e) {
                acum++;
                label.setBounds(150, 150, 300, 30);
                if(acum > 1){
                label.setText("Botón pulsado "+acum+" veces");
                } else {
                    label.setText("Botón pulsado 1 vez");
                }
            }
        };

        button.addActionListener(accionClick);
    }

}
