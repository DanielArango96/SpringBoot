package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionPedido;
import com.example.Store.modelos.Pedido;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorios.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServicio {
    @Autowired
    ValidacionPedido validacionPedido;
    @Autowired
    PedidoRepositorio pedidoRepositorio;

    public Pedido guardarPedido(Pedido datosPedido)throws Exception{
        try{
            if (validacionPedido.validarFechaYHora(datosPedido.getFechaYHora())){
                return pedidoRepositorio.save(datosPedido);
            }return null;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }
    public Pedido consultarPedidoId(Integer idPedido)throws Exception{
        try{
            if (pedidoRepositorio.findById(idPedido).isPresent()){
                return pedidoRepositorio.findById(idPedido).get();

            }else{
                throw new Exception("pedido no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Pedido> buscarTodosPedido()throws Exception{
        try{
            return pedidoRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public Pedido editarPedido(){
        return null;
    }
    public boolean eliminarPedido(){
        return true;
    }

}
