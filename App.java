import java.util.ArrayList;
import java.util.List;

import Puzze.Arreglos;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Character character = ApiUtil.getCharacterById(2);
            System.out.println("Nombre: " + character.name);
            System.out.println("Estado: " + character.status);
            // Imprimir más datos según sea necesario
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
