package com.example.Store.controladores;

import com.example.Store.modelos.Pedido;
import com.example.Store.modelos.Usuario;
import com.example.Store.servicios.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("storeapi/v1/pedido")
public class PedidoControlador {
    @Autowired
    PedidoServicio pedidoServicio;

    @PostMapping
    public ResponseEntity<?> guardarPedido(@RequestBody Pedido datosPedido){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(pedidoServicio.guardarPedido(datosPedido));
        }catch(Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }

    }
}
