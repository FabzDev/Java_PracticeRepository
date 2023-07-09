package igu.practica.Ejercicio5;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class Cronometro {
    public static void main(String[] args) {
        TimerTask listen = new TimerTask() {
            @Override
            public void run() {
                System.out.println(LocalDateTime.now());


            }
        };
        Timer crono = new Timer();
        crono.schedule((TimerTask) listen, 1000, 10);
    }
}