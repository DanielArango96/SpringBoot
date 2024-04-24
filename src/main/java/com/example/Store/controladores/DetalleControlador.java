package com.example.Store.controladores;

import com.example.Store.modelos.Detalle;
import com.example.Store.servicios.DetalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("storeapi/v1/detalle")
public class DetalleControlador {
    @Autowired
    DetalleServicio detalleServicio;

    @PostMapping
    public ResponseEntity<?> guardarDetalle(@RequestBody Detalle datosDetalle){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(detalleServicio.guardarDetalle(datosDetalle));
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }

    }
}
