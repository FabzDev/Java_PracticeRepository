package com.practice.excercises.chapther1;

import java.util.Scanner;

public class PrecioMayor6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Digita la cantidad de productos a ingresar");
		int numeroDeVentas = scan.nextInt();

		double ventaTop = 0;
		double ventaLow = 0;
		double acumVentas = 0;
		int mayorQue200 = 0;

		for (int i = 0; i < numeroDeVentas; i++) {
			System.out.println("Ingresa el valor del producto " + (i + 1) + ".");
			double venta = scan.nextDouble();
			
			if (i==0) {
				ventaTop = venta;
				ventaLow = venta;
			}
			
			if (venta > ventaTop)
				ventaTop = venta;

			if (venta < ventaLow)
				ventaLow = venta;
			
			if (venta > 200)
				mayorQue200++;
			
			acumVentas += venta;
		}

		System.out.println("El producto de mayor precio es: " + ventaTop + ".");
		System.out.println("El producto de menor precio es: " + ventaLow + ".");
		System.out.println("El promedio de precios es: " + (acumVentas / numeroDeVentas) + ".");
		System.out.println("Hay " + mayorQue200 + " productos con precio mayor a $200.");
	}
}
