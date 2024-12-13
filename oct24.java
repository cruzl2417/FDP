public class oct24 {
    public static void main(String[] args) {
        
      //realizar un programa que utilice un arreglo de 2 dimensiones que contenga las tablas de multiplicar del 1 al 100, algo similar a esto (hasta el 100x100):
        int[] tablas = new int[100];
      
        for (int i = 0; i < 100; i++) {
        for (int j = 0; j < 100; j++) {
                tablas[j] = (i + 1) * (j + 1);
                System.out.print((i + 1) + " x " + (j + 1) + " = " + tablas[j] + "\t");
        }
        }
   }
}
