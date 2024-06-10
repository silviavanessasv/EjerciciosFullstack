package com.certidevs.excepciones;

import java.io.IOException;

public class Main5 {

    /*
    EXCEPCIONES CHECKED (COMPROBADAS)
     */
    public static void main(String[] args) {


        // obligatorio usar el try catch
        // o declararla con throws en este método main
        try {
            realizarAccion();
        } catch (IOException e) {
            System.out.println("No se ha podido leer el archivo");
        }

    }

    public static void realizarAccion() throws IOException {

        // .... cosas ....

        throw new IOException(); // checked, obliga a declararla en el método con throws
    }
}
