package com.practice.excercises.chapther1;

import java.util.Scanner;

public class ProduccionDeCarbon5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double valorAcumulado=0;
		for (int i = 0; i < 12; i++) {
			System.out.println("Ingrese la producción de carbón del mes " + (i+1) + ".");
			double valorMensual = scan.nextDouble();
			valorAcumulado += valorMensual;
		}
		System.out.println("El promedio anual es: " + valorAcumulado/12);
	}
}
