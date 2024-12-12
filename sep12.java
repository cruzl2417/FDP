import java.util.Scanner;

public class sep12 {
    public static void main(String[]args) {

        //ej 1, 12 sep
        //1 ) Crea un programa que solicite por teclado 5 numeros y te muestre como resultado el numero MAYOR que fue introducido.
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce 5 números:");
        int mayor = Integer.MIN_VALUE;

        for (int i = 0; i < 5; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            int num = scanner.nextInt();
            if (num > mayor) {
                mayor = num;
            }
        }
        System.out.println("El número mayor es: " + mayor);

        //ej 2 
        //2) Crea un programa que nos indique cuantos numeros menores de 1000 son multiplos tanto de 3 y de 5 (ej, 15, 30,...).
        int contador = 0;

        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                contador++;
            }
        }

        System.out.println("La cantidad de numeros menores de 1000 y múltiplos de 3 y 5 es: " + contador);

    }
}
