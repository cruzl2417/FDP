package com.example;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class Main {
        private static ArrayList<Product> productos = new ArrayList<>();
        private static int lastProductId = 20;

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ApiConnection.inicializarProductos();
        gestionarMenu();
    }

    private static void gestionarMenu() {
        int opcion;
        do {
            System.out.println("*********************************************************");
            System.out.println("* Bienvenido al Catálogo de Productos.                  *");
            System.out.println("* Selecciona una de las siguientes opciones:            *");
            System.out.println("* 1) Buscar Productos                                   *");
            System.out.println("* 2) Agregar Producto                                   *");
            System.out.println("* 3) Eliminar Producto                                  *");
            System.out.println("* 0) Salir                                              *");
            System.out.println("*********************************************************");
            System.out.print("Elige una opción: ");
            
            opcion = scan.nextInt();
            
    
            switch (opcion) {
                case 0 -> System.out.println("Saliendo de la aplicación...");
                case 1 -> BuscarProducto();
                case 2 -> AgregarProducto();
                case 3 -> BorrarProducto();
                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 0); 
    }

    private static void BuscarProducto(){ 
        System.out.println("1) Buscar productos por: ");
        System.out.println("a) ID");
        System.out.println("b) Categoria");
        System.out.println("c) Nombre");   
        System.out.println("d) Salir del buscador de productos");   
        System.out.println("*********************************************************");
        ElegirBuscador();
    }

    private static void AgregarProducto(){
        System.out.println("Completa los campos para agregar el producto:");
        System.out.println("Ingresa el nombre del producto: ");
        scan.nextLine();

        String nombre = scan.nextLine();
        
        System.out.println("Ingresa el precio del producto: ");
        double precio = scan.nextDouble();
        scan.nextLine();
        
        System.out.println("Ingresa la descripción del producto: ");
        String descripcion = scan.nextLine();
        
        System.out.println("Ingresa la categoría del producto: ");
        String categoria = scan.nextLine();
        
        System.out.println("Ingresa la URL de la imagen del producto: ");
        String imagen = scan.nextLine();
        
        System.out.println("Ingresa la calificación del producto (por ejemplo, 4.5): ");
        double calificacion = scan.nextDouble();
        scan.nextLine();

        System.out.print("Ingresa la cantidad de votos para el producto: ");
        int votos = scan.nextInt();
        scan.nextLine();
        
        lastProductId++;
        
        Rating rating = new Rating(calificacion, votos);
        Product producto = new Product(lastProductId, nombre, precio, descripcion, categoria, imagen, rating);
        ApiConnection.AgregarProducto(producto);

        productos.add(producto);
        
        System.out.println("Producto agregado con éxito.");
    }

    private static void BorrarProducto() {
        System.out.print("Ingresa el ID del producto a borrar: ");
        int id = scan.nextInt();
        scan.nextLine(); 
        
        ApiConnection.EliminarProducto(id);
    }
    
    
    private static void ElegirBuscador() {
        System.out.print("Elige una opción (a, b, c, d): ");
        char c = scan.next().charAt(0);
        switch (c) {
            case 'a' -> BuscarPorID();
            case 'b' -> BuscarPorCategorias();
            case 'c' -> BuscarPorNombre();
            case 'd' -> System.out.println("Saliendo del buscador de productos.");
            default -> {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
                ElegirBuscador();
            }
        }
    }

    private static void BuscarPorID(){
        System.out.println("Has elegido buscar por ID.");
        System.out.print("Ingresa su Id: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.println("*********************************************************");
        Product producto = ApiConnection.imprimirPorID(id);
        if (producto != null) {
            System.out.println("Producto encontrado:");
            System.out.println("Nombre: " + producto.getTitle());
            System.out.println("Precio: " + producto.getPrice() + "$");
            PDFYesOrNo(producto);
            } else {
                System.out.println("No se encontró un producto con el ID proporcionado.");
            }
    }

    private static void BuscarPorCategorias() {
        System.out.println("Has elegido buscar por categoría.");
        Set<String> categorias = ApiConnection.obtenerCategoriasLocales();
        
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías disponibles.");
            return; 
        }
        
        System.out.println("Categorías disponibles:");
        int count = 1;
        ArrayList<String> listaCategorias = new ArrayList<>(categorias); 
        for (String categoria : listaCategorias) {
            System.out.println(count + ") " + categoria);
            count++;
        }
        
        System.out.print("Elige el número de la categoría: ");
        int opcion = scan.nextInt();
        scan.nextLine(); // Consumir el salto de línea pendiente
        
        if (opcion > 0 && opcion <= listaCategorias.size()) {
            String categoriaSeleccionada = listaCategorias.get(opcion - 1);
            ArrayList<Product> productosEnCategoria = ApiConnection.buscarProductosPorCategoria(categoriaSeleccionada);
            
            if (!productosEnCategoria.isEmpty()) {
                System.out.println("Productos en la categoría '" + categoriaSeleccionada + "':");
                for (Product producto : productosEnCategoria) {
                    System.out.println("ID: " + producto.getId());
                    System.out.println("Nombre: " + producto.getTitle());
                    System.out.println("Precio: " + producto.getPrice() + "$");
                    System.out.println("---------------------------------------------------");
                }
            } else {
                System.out.println("No hay productos disponibles en la categoría seleccionada.");
            }
        } else {
            System.out.println("Opción no válida. Volviendo al menú principal.");
        }
    }

    private static void BuscarPorNombre(){
        System.out.println("Has elegido buscar por nombre.");
        System.out.print("Ingresa el nombre o parte del nombre del producto: ");
        scan.nextLine(); 
        String nombre = scan.nextLine();

        ArrayList<Product> productosEncontrados = ApiConnection.buscarProductosPorNombre(nombre);
        if (!productosEncontrados.isEmpty()) {
            System.out.println("Productos encontrados:");
            for (Product producto : productosEncontrados) {
                System.out.println("ID: " + producto.getId());
                System.out.println("Nombre: " + producto.getTitle());
                System.out.println("Precio: " + producto.getPrice() + "$");
                System.out.println("Categoría: " + producto.getCategory());
                System.out.println("---------------------------------------------------");
            }
        } else {
            System.out.println("No se encontraron productos con el nombre proporcionado.");
        }
    }
    
    private static void PDFYesOrNo(Product producto) {
        System.out.print("¿Quieres descargar el PDF de este artículo? (s/n): ");
        String confirmacion = scan.nextLine();
        switch (confirmacion.toLowerCase()) {
            case "s" -> {
                ProductPDFCreator.guardaPDFDeProducto(producto);
                System.out.println("PDF descargado exitosamente.");
            }
            case "n" -> System.out.println("Volviendo al menú principal...");
            default -> {
                System.out.println("Opción no válida.");
                PDFYesOrNo(producto);
            }
        }
    }
    
}
