/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.StringTokenizer;

/**
 *
 * @author fabio
 */
public class TextFormatter {

    public static void main(String[] args) {

        String str = "No cabe duda que la parte más importante de cualquier lenguaje de programación es saber cómo manejar las variables alfanumericas, porque finalmente, cualquier programa realiza una acción para un usuario, y como tal hay que comunicarse, y si no hubiera mensajes de texto, cómo te comunicarías?.";

        StringTokenizer st = new StringTokenizer(str);
        String newS = "";
        int lineWidth = 40;
        int temp = 0;

        System.out.println();
        while (temp <= (str.length() - 40)) {

            for (int i = temp; i < temp + lineWidth; i++) {

                newS = newS + str.charAt(i);
            }
            System.out.println(newS);
            System.out.println();
            temp += lineWidth;
            newS = "";
        }
    }

}
