
package model;


public class Modelo {
    int numero1;
    int numero2;
    int resultado;

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public int getResultado() {
        return resultado;
    }

    public int suma(){
        resultado = numero1 + numero2;
        return resultado;
    }
}
