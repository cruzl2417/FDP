import java.util.Scanner;

public class sep25a27 {
    public static void main(String[] args) {
        
        //1) Declara un String que contenga tu nombre, después muestra un mensaje de bienvenida por consola. Por ejemplo: si introduzco «Fernando», me aparezca «Bienvenido Fernando».
        String nombre = "Fernando"; 
        System.out.println("Bienvenido " + nombre);

        //2) Pide por teclado un número entero positivo y muestra el número de cifras que tiene. Por ejemplo: si introducimos 1250, nos muestre que tiene 4 cifras. Tendremos que controlar si tiene una o mas cifras, al mostrar el mensaje.
        System.out.print("Introduce un número entero positivo: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        if (num <= 0) {
            System.out.println("Por favor, introduce un número positivo.");
        } else {
            int digitos = String.valueOf(num).length();
            System.out.println("El número " + num + " tiene " + digitos + (digitos == 1 ? " cifra." : " cifras."));
        }

        //4) Programa que lea una cantidad de grados centígrados y la pase a grados Fahrenheit. La fórmula correspondiente para pasar de grados centígrados a fahrenheit es: F = 32 + ( 9 * C / 5). De ser posible crear una Función para el calculo.
        System.out.print("Introduce la temperatura en grados centígrados: ");
        double cent = scanner.nextDouble();

        double fahr = 32 + (9*cent/5);
        System.out.println("La temperatura en grados Fahrenheit es: " + fahr);

        //Programa que tome como dato de entrada un número que corresponde a la longitud del radio una esfera y nos calcula y escribe el volumen de la esfera que se corresponden con dicho radio. La fórmula para calcular el volumen de la esfera es:
        System.out.print("Introduce el radio de la esfera: ");
        double radio = scanner.nextDouble();

        if (radio <= 0) {
            System.out.println("Por favor, introduce un radio positivo.");
        } else {
            double volumen = (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
            System.out.println("El volumen de la esfera con radio " + radio + " es: " + volumen);
        }
    }

}
