package igu.practica.Ejercicio5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cronotime extends JFrame {
    int miliseg = 0;
    int seg = 0;
    int min = 0;
    int hora = 0;
    JLabel lbTime = new JLabel();
    Timer timer;

    public Cronotime(){
        initComponents();
        timer();
        setSize(600, 250);
        setDefaultCloseOperation(3);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);

        JLabel etiqueta1 = new JLabel();
        etiqueta1.setBounds(0,0,600,250);
        var img = new ImageIcon("src/main/resources/cronoimg.jpg");
        etiqueta1.setIcon(img);
        panel.add(etiqueta1);

        JLabel etiqueta2 = new JLabel();
        etiqueta2.setBounds(10,-20,300,250);
        ImageIcon img2 = new ImageIcon("src/main/resources/rejoj2.png");
        etiqueta2.setIcon(new ImageIcon(img2.getImage().getScaledInstance(150,200,2)));
        etiqueta1.add(etiqueta2);

        lbTime.setBounds(200,50,400,50);
        lbTime.setText("Cronometro: 00:00:00:00");
        lbTime.setAlignmentX(0);
        lbTime.setFont(new Font("Inter", 1, 28));
        lbTime.setForeground(Color.white);
        etiqueta1.add(lbTime);

        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });
        btnStart.setBounds(200,150,100,20);
        btnStart.setForeground(Color.white);
        btnStart.setBackground(Color.black);
        btnStart.setFont(new Font("Inter", 1, 18));
        btnStart.setBorder(null);
        etiqueta1.add(btnStart);

        JButton btnPause = new JButton("Pause");
        btnPause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });
        btnPause.setBounds(310,150,100,20);
        btnPause.setForeground(Color.white);
        btnPause.setBackground(Color.black);
        btnPause.setFont(new Font("Inter", 1, 18));
        btnPause.setBorder(null);
        etiqueta1.add(btnPause);

        JButton btnRestart = new JButton("Restart");
        btnRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stop();
            }
        });
        btnRestart.setBounds(420,150,100,20);
        btnRestart.setForeground(Color.white);
        btnRestart.setBackground(Color.black);
        btnRestart.setFont(new Font("Inter", 1, 18));
        btnRestart.setBorder(null);
        etiqueta1.add(btnRestart);

    }

    private void timer() {

        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miliseg++;
                if (miliseg == 100) {
                    miliseg = 0;
                    seg++;
                }
                if (seg == 60) {
                    seg = 0;
                    min++;
                }
                if (min == 60) {
                    min = 0;
                    hora++;
                }

                lbTime.setText("Cronometro: " + String.format("%02d", hora) + ":" + String.format("%02d", min) + ":" + String.format("%02d", seg) + ":" + String.format("%02d", miliseg));

            }

        });

    }

    private void stop(){
        miliseg = 0;
        seg = 0;
        min = 0;
        hora = 0;
        lbTime.setText("Cronometro: 00:00:00:00");

    }
}
