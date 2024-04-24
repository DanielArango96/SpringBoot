package com.example.Store.controladores;

import com.example.Store.modelos.Producto;
import com.example.Store.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("storeapi/v1/producto")
public class ProductoControlador {
    @Autowired
    ProductoServicio productoServicio;

    @PostMapping
    public ResponseEntity<?> guardarProducto(@RequestBody Producto datosProducto){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(productoServicio.guardarProducto(datosProducto));
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }

    }
}
