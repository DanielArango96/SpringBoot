package com.example.Store.helpers;

import com.example.Store.modelos.Producto;
import org.springframework.stereotype.Component;

@Component
public class ValidacionProducto {
    public static boolean validarNombre(String nombre)throws Exception{
        if (nombre.length()==0){
            throw new Exception("El nombre no puede estar vacio");
        }
        if (nombre.length()>60){
            throw new Exception("El nombre no puede tener mas de 60 caracteres");
        }
        String regex = "^[a-zA-Z\\s]+$"; // Cambiado para permitir solo letras y espacios
        // Evaluamos si el nombre coincide con la expresión regular
        if (!nombre.matches(regex)) {
            throw new IllegalArgumentException("Revisa el nombre ingresado, solo puede contener letras y espacios");
        }
        return true;
    }
    public static boolean validarReferencia(String referencia)throws Exception{
        if (referencia.length()==0){
            throw new Exception("La referencia no puede estar vacio");
        }
        if (referencia.length()>14){
            throw new Exception("la referencia no puede tener mas de 14 caracteres");
        }

        return true;
    }

    public static boolean validarTalla(String talla)throws Exception{
        if (talla.length()==0){
            throw new Exception("La talla no puede estar vacia");
        }
        if (talla.length()>3){
            throw new Exception("la talla no puede tener mas de 3 caracteres");
        }

        return true;
    }
    public static boolean validarCantidadBodega(Integer cantidadBodega)throws Exception{
        if (cantidadBodega<0){
            throw new Exception("la cantidad en bodega no puede ser un numero negativo");
        }
        String numeroString = String.valueOf(cantidadBodega); // Convertir el Integer a una cadena

        for (char c : numeroString.toCharArray()) {
            if (!Character.isDigit(c)) { // Verificar si el carácter no es un dígito
                throw new Exception("El número contiene caracteres no numéricos");
            }
        }
        return true;
    }
    public static boolean validPrecioUnitario(Integer precioUnitario)throws Exception{
        if (precioUnitario<0){
            throw new Exception("El precio unitario no puede ser un numero negativo");
        }
        if (precioUnitario==0){
            throw new Exception("El precio unitario no puede ser cero");
        }
        String numeroString = String.valueOf(precioUnitario); // Convertir el Integer a una cadena

        for (char c : numeroString.toCharArray()) {
            if (!Character.isDigit(c)) { // Verificar si el carácter no es un dígito
                throw new Exception("El número contiene caracteres no numéricos");
            }
        }

        return true;
    }
    public static boolean validarDescripcion(String descripcion)throws Exception{
        if (descripcion.length()==0){
            throw new Exception("La descripcion no puede estar vacia");
        }
        if (descripcion.length()>100){
            throw new Exception("La descripcion no puede tener mas de 100 caracteres");
        }
        return true;
    }
    public static boolean validarFotografia(String fotografia)throws Exception{
        if (fotografia.length()==0){
            throw new Exception("La fotografia no puede estar vacia");
        }
        if (fotografia.length()>255){
            throw new Exception("La fotografia no puede tener mas de 255 caracteres");
        }
        return true;
    }
    public static boolean validarProducto(Producto producto)throws Exception{
        return validarNombre(producto.getNombreProducto())&&validarDescripcion(producto.getDescripcion())&&
                validarTalla(producto.getTalla())&&validarReferencia(producto.getReferencia())&&validarFotografia(producto.getFotografia())&&
                validarCantidadBodega(producto.getCantidadBodega())&&validPrecioUnitario(producto.getPrecioUnitario());
    }
}
