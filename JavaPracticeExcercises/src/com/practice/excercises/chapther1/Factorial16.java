package com.practice.excercises.chapther1;

public class Factorial16 {
	public static void main(String[] args) {
		int n = 6;
		int temp;
		int resultado=1;
		
//		for (int i = 1; i < n; i++) {
//			resultado = resultado * (i+1);
//		} 
		
		while (n != 0) {
			resultado = resultado * (n);
			n--;
		}
			System.out.println(resultado);
	}
}
