import java.util.Scanner;
public class ejCubo {
    public static void main(String[]args) {
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Numero con decimales: ");
        double num = entrada.nextDouble();
        double res = calcularCubo(num);
        System.out.println(res);

    }

        static double calcularCubo(double cubo){
        return cubo*cubo*cubo;
   
    }
}
