package com.example.Store.controladores;

import com.example.Store.modelos.Detalle;
import com.example.Store.servicios.DetalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

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
    @GetMapping ("{id}")
    public ResponseEntity<?> consultarDetalleId (@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(detalleServicio.consultarDetalleId(id));
        }catch (Exception error){
            Map<String, Object> errorDetails=new LinkedHashMap<>();
            errorDetails.put("Timestamp", LocalDateTime.now());
            errorDetails.put("Message", error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }

    public ResponseEntity<?> buscarTodosDetalle (){
        try{
            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(detalleServicio.buscarTodosDetalle());
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
