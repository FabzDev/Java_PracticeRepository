package igu.practica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ejercicio3 {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JButton btnRojo = new JButton();
    JButton btnVerde = new JButton();
    JButton btnAzul = new JButton();
    int rojo = 0;
    int verde = 0;
    int azul = 0;
    public Ejercicio3() {
        putFrame();
        putPanel();
        putLabels();
        putJButtons();
    }

    public void putFrame(){
        frame.setSize(new Dimension(640, 480)); // Definir tamaño de la ventana
        frame.setLocationRelativeTo(null); //Ubica la ventana en el centro de la pantalla
        frame.setTitle("Juego de colores"); // Definir el título de la ventana
        frame.setVisible(true); // Definir la ventana como visible
        frame.setDefaultCloseOperation(3); // Definir cerrar la aplicación al cerrar la pantalla
        frame.setMinimumSize(new Dimension(frame.getWidth(),frame.getHeight())); // Definir el tamaño minimo de la ventana
    }

    private void putPanel() {
        panel.setSize(frame.getWidth(), frame.getHeight());
        panel.setLayout(null);
        panel.setBackground(new Color(rojo, verde, azul));
        frame.add(panel);
    }

    private void putLabels(){
        label.setBounds(145, 50, 320, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Inter", 0, 18));
        panel.add(label);
    }

    private void putJButtons(){
        btnRojo.setBounds(80, 350, 120, 30);
        btnRojo.setText("Rojo");
        btnRojo.setForeground(Color.RED);
        btnRojo.setFont(new Font("Inter", 0, 20));

        ActionListener test = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAzul.removeMouseWheelListener(new MouseWheelListener() {
                    @Override
                    public void mouseWheelMoved(MouseWheelEvent e) {

                    }
                });
            }
             ;
        };
        panel.add(btnRojo);

        btnVerde.setBounds(240, 350, 120, 30);
        btnVerde.setText("Azul");
        btnVerde.setForeground(Color.GREEN);
        btnVerde.setFont(new Font("Inter", 0, 20));
        btnVerde.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarVerde();
            }
        });
        panel.add(btnVerde);

        btnAzul.setBounds(400, 350, 120, 30);
        btnAzul.setText("Azul");
        btnAzul.setForeground(Color.BLUE);
        btnAzul.setFont(new Font("Inter", 0, 20));
        btnAzul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarAzul();
            }
        });
        panel.add(btnAzul);
    }

    public void modificarRojo(){
        panel.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if(e.getPreciseWheelRotation()>0 && rojo < 255){
                    rojo++;}
                    else if(e.getPreciseWheelRotation() < 0 && rojo>0){
                    rojo--;
                }
                System.out.println("rojo: " + rojo);
            }
        });
    }

    public void modificarVerde(){
        panel.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if(e.getPreciseWheelRotation()>0 && verde < 255){
                    verde++;}
                else if(e.getPreciseWheelRotation() < 0 && verde>0){
                    verde--;
                }
                System.out.println("verde: " + verde);
            }
        });
    }

    public void modificarAzul(){
        panel.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if(e.getPreciseWheelRotation()>0 && azul < 255){
                    azul++;}
                else if(e.getPreciseWheelRotation() < 0 && azul>0){
                    azul--;
                }
                System.out.println("azul: " + azul);
            }
        });
    }


}
