package com.example.Store.controladores;

import com.example.Store.modelos.Usuario;
import com.example.Store.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("storeapi/v1/usuario")

public class UsuarioControlador {
    @Autowired
    UsuarioServicio usuarioServicio;
    //el controlador debe crear un metodo por cada servicio programado

    // metodo para guardar
    @PostMapping
    public ResponseEntity<?> guardarUsuario(@RequestBody Usuario datosUsuario){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usuarioServicio.guardarUsuario(datosUsuario));
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }

    }
@GetMapping
public ResponseEntity<?> consultarUsuarios(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(usuarioServicio.buscarTodosUsuarios());
        }catch (Exception error){
            Map<String, Object> errorDetails=new LinkedHashMap<>();
            errorDetails.put("Timestamp", LocalDateTime.now());
            errorDetails.put("Message", error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
}
@GetMapping("{id}")
public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(usuarioServicio.consultarUsuarioId(id));

        }catch (Exception error){
            Map<String, Object> errorDetails=new LinkedHashMap<>();
            errorDetails.put("Timestamp", LocalDateTime.now());
            errorDetails.put("Message", error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());

        }
}

}
