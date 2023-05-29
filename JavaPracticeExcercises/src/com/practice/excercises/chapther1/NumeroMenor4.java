package com.practice.excercises.chapther1;

import java.util.Scanner;

public class NumeroMenor4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingresa los 3 numero a evaluar");
		double n1 = scan.nextDouble();
		double n2 = scan.nextDouble();
		double n3 = scan.nextDouble();
		double resultado;

		if(n1<n2 && n1<n3) {
			resultado = n1;
		} else if(n2<n1 && n2<n3) {
			resultado = n2;
		} else {
			resultado = n3;
		}
		
//		if (n1 < n2) {
//			if (n1 < n3) {
//				resultado = n1;
//			} else {
//				resultado = n3;
//			}
//		} else {
//			if (n2 < n3) {
//				resultado = n2;
//			} else {
//				resultado = n3;
//			}
//		}
		
		System.out.println("El numero menor es: " + resultado);
	}
}
