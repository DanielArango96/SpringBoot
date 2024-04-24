package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionProducto;
import com.example.Store.helpers.ValidacionTipoPrenda;
import com.example.Store.modelos.Producto;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorios.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {
    @Autowired
    ValidacionProducto validacionProducto;
    @Autowired
    ProductoRepositorio productoRepositorio;

    public Producto guardarProducto(Producto datosProducto)throws Exception{
        try{
            if (validacionProducto.validarProducto(datosProducto)){
                return productoRepositorio.save(datosProducto);
            }return null;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }
    public Producto  consultarProductoId(Integer idProducto)throws Exception{
        try{
            if (productoRepositorio.findById(idProducto).isPresent()){
                return productoRepositorio.findById(idProducto).get();

            }else{
                throw new Exception("producto no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Producto> buscarTodosProducto()throws Exception{
        try{
            return productoRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public Producto  editarProducto(){
        return null;
    }
    public boolean eliminarProducto(){
        return true;
    }

}
