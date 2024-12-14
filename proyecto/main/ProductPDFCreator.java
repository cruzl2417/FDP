package com.example;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class ProductPDFCreator {

    public static void guardaPDFDeProducto(Product product){
        // Nombre del archivo PDF que se generará
        String pdfPath = "producto" + product.getId() + ".pdf";
        
        try {
            // Creación del documento PDF
            Document document = new Document();
            
            // Crear el escritor de PDF
            PdfWriter.getInstance(document, new java.io.FileOutputStream(pdfPath));
            
            // Abrir el documento para agregar contenido
            document.open();

            // Agregar texto al PDF
            document.add(new Phrase("Nombre del Producto: " + product.getTitle() + "\n" ));
            document.add(new Phrase("Precio del Producto: " + product.getPrice() + "$\n\n" ));
            document.add(new Phrase("Descripcion del Producto: " + product.getDescription() + "\n\n" ));
            document.add(new Phrase("Categoria del Producto: " + product.getCategory() + "\n\n" ));
            document.add(new Phrase("Rating del Producto: " + product.getRating().getRate() + "/5 con "+ product.getRating().getCount()+ " votos \n\n" ));
            
            // Descargar y agregar imagen desde una URL
            String imageUrl = product.getImage(); // URL de la imagen
            Image image = Image.getInstance(imageUrl);
            
            // Ajustar el tamaño de la imagen si es necesario
            image.scaleToFit(300, 300); // Ajusta el tamaño máximo (ancho, alto)
            document.add(image); // Agregar imagen al documento
            
            // Cerrar el documento
            document.close();
            
            System.out.println("PDF creado con éxito en: " + pdfPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
