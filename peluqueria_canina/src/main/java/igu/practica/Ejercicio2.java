package igu.practica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio2 {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JRadioButton radioButton1 = new JRadioButton();
    JRadioButton radioButton2 = new JRadioButton();
    JRadioButton radioButton3 = new JRadioButton();
    JRadioButton radioButton4 = new JRadioButton();
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JLabel label4 = new JLabel();
    JLabel labelImg = new JLabel();
    JLabel labelTitulo = new JLabel();
    ButtonGroup group = new ButtonGroup();

    public Ejercicio2(){
        putFrame();
        putPanel();
        putRadioButtons();
        putLabels();
        putImgLabelEmpty();
    }

    public void putFrame(){
        frame.setSize(new Dimension(800, 520)); // Definir tamaño de la ventana
        frame.setLocationRelativeTo(null); //Ubica la ventana en el centro de la pantalla
        frame.setTitle("Selección de deporte"); // Definir el título de la ventana
        frame.setVisible(true); // Definir la ventana como visible
        frame.setDefaultCloseOperation(3); // Definir cerrar la aplicación al cerrar la pantalla
        frame.setMinimumSize(new Dimension(frame.getWidth(),frame.getHeight())); // Definir el tamaño minimo de la ventana
    }

    private void putPanel() {
        panel.setSize(frame.getWidth(), frame.getHeight());
        panel.setLayout(null);
        frame.add(panel);
    }

    private void putRadioButtons() {
        radioButton1.setBounds(50, 120, 20, 20);
        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioButton1.isSelected())
                    putImgLabel("futbol");
            }
        });
        radioButton2.setBounds(50, 180, 20, 20);
        radioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioButton2.isSelected())
                    putImgLabel("baloncesto");
            }
        });
        radioButton3.setBounds(50, 240, 20, 20);
        radioButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioButton3.isSelected())
                    putImgLabel("tenis");
            }
        });
        radioButton4.setBounds(50, 300, 20, 20);
        radioButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioButton4.isSelected())
                    putImgLabel("natacion");
            }
        });
        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(radioButton3);
        panel.add(radioButton4);
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        group.add(radioButton4);
    }

    private void putLabels(){
        labelTitulo.setBounds(50, 30, 350, 20);
        labelTitulo.setText("Elige tu deporte favorito");
        labelTitulo.setFont(new Font("Inter", 0, 20));
        panel.add(labelTitulo);


        label1.setBounds(80, 120, 120, 20);
        label1.setText("Futbol");
        label1.setFont(new Font("Inter", 0, 20));
        panel.add(label1);

        label2.setBounds(80, 180, 120, 20);
        label2.setText("Baloncesto");
        label2.setFont(new Font("Inter", 0, 20));
        panel.add(label2);

        label3.setBounds(80, 240, 120, 20);
        label3.setText("Tenis");
        label3.setFont(new Font("Inter", 0, 20));
        panel.add(label3);

        label4.setBounds(80, 300, 120, 20);
        label4.setText("Natación");
        label4.setFont(new Font("Inter", 0, 20));
        panel.add(label4);
    }

    public void putImgLabel(String dep) {
        labelImg.setBounds(220, 70, 500, 350);
        ImageIcon img = new ImageIcon("src/main/resources/" + dep + ".jpg");
        labelImg.setIcon(new ImageIcon(img.getImage().getScaledInstance(labelImg.getWidth(), labelImg.getHeight(), 4)));
        panel.add(labelImg);
    }

    public void putImgLabelEmpty(){
        labelImg.setBounds(220, 70, 500, 350);
        panel.add(labelImg);
    }

}
