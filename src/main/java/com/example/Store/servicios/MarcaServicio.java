package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionMarca;
import com.example.Store.modelos.Marca;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorios.MarcaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServicio {
    @Autowired
    ValidacionMarca validacionMarca;
    @Autowired
    MarcaRepositorio marcaRepositorio;

    public Marca guardarMarca(Marca datosMarca)throws Exception{
        try{
            if (validacionMarca.validarMarca(datosMarca)){
                return marcaRepositorio.save(datosMarca);
            }return null;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }
    public Marca consultarMarcaId(Integer idMarca)throws Exception{
        try{
            if (marcaRepositorio.findById(idMarca).isPresent()){
                return marcaRepositorio.findById(idMarca).get();

            }else{
                throw new Exception("marca no encontrada");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Marca> buscarTodosMarca()throws Exception{
        try{
            return marcaRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public Marca editarMarca(){
        return null;
    }
    public boolean eliminarMarca(){
        return true;
    }

}
