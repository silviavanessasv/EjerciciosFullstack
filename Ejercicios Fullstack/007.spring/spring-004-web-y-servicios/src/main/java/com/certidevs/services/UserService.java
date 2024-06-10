package com.certidevs.services;

import com.certidevs.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Javadoc
 * Clase de operaciones para trabajar con objetos de tipo User
 * Principalmente métodos CRUD
 */
@Service
@AllArgsConstructor
public class UserService {

    // COMENTADO PARA EVITAR REFERENCIA CIRCULAR
    // YA SE INYECTA UserService en ProductService
    // private ProductService productService;

    /**
     * Método ficticio que simula obtener un usuario
     * de base de datos utilizando como filtro su clave
     * primaria que es el id.
     * @param id clave primaria tipo Long
     * @return Objeto de la clase User ficticio hard-coded
     */
    public User findById(Long id) {
        //if(productService == null)
         //   System.out.println("ERROR: productService es null!");

        // OBJETIVO: productService no debería ser null porque se ha inyectado

        return new User(id, "usuario1", "u1@gmail.com", "admin");
    }
}
