package com.example.Store.helpers;

import com.example.Store.modelos.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ValidacionUsuario {
    public static boolean validarNombres(String nombres)throws Exception{
        if (nombres.length()==0){
            throw new Exception("El nombre no puede estar vacio");
        }
        if (nombres.length()>50){
            throw new Exception("El nombre no puede tener mas de 50 caracteres");
        }
        String regex="^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$";
        // evaluo si el nombre coincide con la expresion
        if (!nombres.matches("[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+")) {
            throw new IllegalArgumentException("Revisa el nombre ingresado ya que solo puede contener letras y espacios");
        }
        return true;
    }
    public static boolean validarCedula(String cedula)throws Exception{
        if (cedula.length()==0){
            throw new Exception("la longitud de la cedula no puede ser cero");
        }
        if (cedula.length()>12){
            throw new Exception("la longitud de la cedula no puede ser mayor a 12");
        }
        String regex = "^[0-9]+$";
        if (!ValidarPatron.evaluarPatron(regex,cedula)){
            throw new Exception("El nit ingresado solo puede tener numeros");
        }
        return true;
    }
    public static boolean validarCorreo(String correo)throws Exception{
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!correo.trim().matches(regex)) {
            throw new IllegalArgumentException("El formato del correo electrónico no es válido");
        }
        if (correo.length()==0){
            throw new Exception("la longitud del correo no puede ser cero");
        }

        return true;
    }
    public static boolean validarSexo(String sexo)throws Exception{
        if (sexo == null || sexo.trim().isEmpty()) {
            throw new IllegalArgumentException("El sexo no puede estar vacío");
        }
        if (sexo.length() != 1 || (!sexo.equalsIgnoreCase("m") && !sexo.equalsIgnoreCase("f"))) {
            throw new IllegalArgumentException("El valor del sexo solo puede ser 'm' o 'f'");
        }
        return true;
    }
    public static boolean codigoPostal(String codigoPostal)throws Exception{
        if (codigoPostal.isEmpty()){
            throw new Exception("la longitud del codigo postal no puede ser cero");
        }
        if (codigoPostal.length()>6){
            throw new Exception("la longitud del codigo postal no puede ser mayor a 6");
        }
        String regex = "^[0-9]+$";
        if (!ValidarPatron.evaluarPatron(regex,codigoPostal)){
            throw new Exception("El codigo postal ingresado solo puede tener numeros");
        }
        return true;
    }
    public static boolean validarUsuario(Usuario usuario) throws Exception {
        return validarNombres(usuario.getNombres()) &&
                validarCedula(usuario.getCedula()) &&
                validarCorreo(usuario.getCorreo()) &&
                validarSexo(usuario.getSexo()) &&
                codigoPostal(usuario.getCodigoPostal());
    }


}
