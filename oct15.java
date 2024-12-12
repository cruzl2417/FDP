public class oct15 {
    public static void main(String[] args) {
        
        //1) Crear un arreglo de 100 elementos de tipo entero.
        //2) Asignar los numeros del 1000 al 1100 en dicho arreglo (utilizar los indices del 0 al 99)
        //3) Mostrar por pantalla todos los valores del arreglo comenzando del indice 99 al 0.
        int[] numeros = new int[100];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = 1000 + i;
        }

        
        System.out.println("comenzando desde 99: ");
        for (int i = numeros.length - 1; i >= 0; i--) {
            System.out.println("indice " + i + ": " + numeros[i]);
        }
    }
}