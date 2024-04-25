package com.example.Store.controladores;

import com.example.Store.modelos.Producto;
import com.example.Store.servicios.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

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
    @GetMapping("{id}")
    public  ResponseEntity<?> consultarProductoId (@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(productoServicio.consultarProductoId(id));
        }catch (Exception error){
            Map<String, Object> errorDetails=new LinkedHashMap<>();
            errorDetails.put("Timestamp", LocalDateTime.now());
            errorDetails.put("Message", error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity <?> buscarTodosProducto (){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(productoServicio.buscarTodosProducto());
        } catch (Exception error){
            Map<String, Object> errorDetails=new LinkedHashMap<>();
            errorDetails.put("Timestamp", LocalDateTime.now());
            errorDetails.put("Message", error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
