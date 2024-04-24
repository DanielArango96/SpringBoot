package com.example.Store.controladores;

import com.example.Store.modelos.Marca;
import com.example.Store.servicios.MarcaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("storeapi/v1/marca")
public class MarcaControlador {
    @Autowired
    MarcaServicio marcaServicio;

    @PostMapping
    public ResponseEntity<?> guardarMarca(@RequestBody Marca datosMarca){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(marcaServicio.guardarMarca(datosMarca));
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }

    }
}
