package com.practice.excercises.chapther1;

import java.util.Scanner;

public class CalcularRectangulo2 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese la valor de la base y altura del rectangulo respectivamente");
		double base = scan.nextDouble();
		double altura = scan.nextDouble();
		
		double area = base * altura;
		double perimetro = 2*base + 2*altura;
		

		System.out.println("Perimetro del rectangulo: " + perimetro);
		System.out.println("Area del rectangulo: " + area);
	}
	
	
	
	
}
