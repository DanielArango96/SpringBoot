package com.example.Store.helpers;

import org.springframework.stereotype.Component;

@Component
public class ValidacionTipoPrenda {
    public static boolean validarNombre(String nombre)throws Exception{
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de prenda no puede estar vacío");
        }
        if (nombre.length()>80){
            throw new Exception("el tipo de prenda no puede tener mas de 80 caracteres");
        }
        String regex = "^[a-zA-Z\\s]+$"; // Cambiado para permitir solo letras y espacios
        // Evaluamos si el nombre coincide con la expresión regular
        if (!nombre.matches(regex)) {
            throw new IllegalArgumentException("Revisa el tipo de prenda ingresado, solo puede contener letras y espacios");
        }
        return true;
    }
}
