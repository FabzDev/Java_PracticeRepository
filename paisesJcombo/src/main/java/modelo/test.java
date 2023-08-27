/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author fabio
 */
public class test {

    public static void main(String[] args) {
        hojas(8);
    }

    public static void hojas(int n) {
        // Dibujando ramas
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n * 2; j++) {
                if ((j >= n - i) && (j <= n + i)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // Dibujando el tallo
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= n * 2; j++) {
                if (j == (n - 1) || j == (n + 1)) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
