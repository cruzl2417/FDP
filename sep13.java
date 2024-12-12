import java.util.Scanner;
public class sep13 {
    public static void main (String[]args) {

        //algoritmo que reciba dos numeros, calcular el triple del primero mas el doble del segundo.
        Scanner entrada = new Scanner(System.in);

        System.out.println("Algoritmo que recibe dos numeros y calcula el triple del primero mas el doble del segundo.");
        System.out.println("Escribe el primer numero: ");
        int numUno = entrada.nextInt();
        System.out.println("Escribe el segundo numero: ");
        int numDos = entrada.nextInt();
        int resSum = 3*(numUno)+2*(numDos);
        System.out.println("El resultado de la operacion es: "+resSum);

        //elabora un algoritmo que lea como entrada un numero menor a cien. Calcula la suma de los numeros entre 1 y dicho numero. Imprime el doble de la suma calculada.
        System.out.println("Algoritmo que lee un numero menor a 100, suma los numeros del 1 a dicho numero e imprime el doble de la suma.");
        System.out.println("Escribe un numero del 1 al 100: ");
        int numUnoCien = entrada.nextInt();

        if (numUnoCien <=100) {
            int sumatoria = 0;
        for (int i = 1; i <= numUnoCien; i++) {
            sumatoria = sumatoria + i;
        }
        System.out.println(sumatoria);
        } else {
            System.out.println("Escribe un numero del 1 al 100");
        }

        //elabora un algoritmo que muestre las tablas del 11 al 20

        int contador = 10;
        int numTab = 5;

        while (contador <= 20) {
            contador = contador + 1;
            System.out.println(numTab+" x "+ contador+" = "+numTab*contador);
        }

    }
        
}