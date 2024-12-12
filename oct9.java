import java.util.Scanner;

public class oct9 {
    public static void main(String[] args) {
        
        //escribe un programa que presente un menu de opciones y obtenga el area de la figura seleccionada, despues de leer los valores necesarios. triangulo, cuadrado, circulo, rectangulo, salir.
        Scanner entrada = new Scanner(System.in);
        System.out.println("Programa para obetener el area de una figura");
        System.out.println("Escribe '1' para obtener el area de un triangulo");
        System.out.println("Escribe '2' para obtener el area de un cuadrado");
        System.out.println("Escribe '3' para obtener el area de un circulo");
        System.out.println("Escribe '4' para obtener el area de un rectangulo");
        System.out.println("Escribe '5' para salir");
        byte opcion = entrada.nextByte();

        if (opcion <= 1) {
            System.out.println("Calcular area de un triangulo");
            System.out.println("Escriba la base del triangulo: ");
            int baseTri = entrada.nextInt();
            System.out.println("Escriba la altura del triangulo: ");
            int AltTri = entrada.nextInt();
            float arTri = (float)(baseTri*AltTri)/2;
            System.out.println("El area del triangulo es: "+arTri);
        } else if (opcion <= 2) {
            System.out.println("Calcular area de un cuadrado");
            System.out.println("Escriba la base o altura del cuadrado: ");
            int ladoCua = entrada.nextInt();
            int arCua = ladoCua*ladoCua;
            System.out.println("El area del cuadrado es: "+arCua);
        } else if (opcion <= 3) {
            System.out.println("Calcular area de un circulo");
            System.out.println("Escriba el radio del circulo: ");
            int radioCir = entrada.nextInt();
            double arCir = (3.1416*radioCir)*(3.1416*radioCir);
            System.out.println("El area del cuadrado es: "+arCir);
        } else if (opcion <= 4) {
            System.out.println("Calcular area de un rectangulo");
            System.out.println("Escriba la base del rectangulo: ");
            int baseRec = entrada.nextInt();
            System.out.println("Escriba la altura del triangulo: ");
            int AltRec = entrada.nextInt();
            int arRec = baseRec*AltRec;
             System.out.println("El area del triangulo es: "+arRec);  
        } else if (opcion <= 5) {
            System.out.println(" ");
    
        } else {
            System.out.println("Escriba un numero de acuerdo al menu");
        }
    }
  }
        

    

