package com.practice.excercises.chapther1;

import java.util.Scanner;

public class DiagramaDeFlujo13 {
	public static void main(String[] args) {
	
		int n = 3;
		int numero = 0;
		int total = 0;

		for (int i = 1; i <= n; i++) {
			if (i == 1)
				numero = 4;
			if (i == 2)
				numero = -8;
			if (i == 3)
				numero = 6;

			int divis = 1;

			int suma = 0;

			while (divis <= numero / 2) {
				if (numero % divis == 0) {
					suma += divis;
				}
				System.out.println("test " + divis);
				divis++;
			}

			if (suma == numero) {
				System.out.println(numero);
				total++;
			}

		}
		System.out.println(total);
	}
}
