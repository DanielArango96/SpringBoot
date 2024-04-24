package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionTipoPrenda;
import com.example.Store.modelos.TipoPrenda;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorios.TipoPrendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPrendaServicio {
    @Autowired
    ValidacionTipoPrenda validacionTipoPrenda;
    @Autowired
    TipoPrendaRepositorio tipoPrendaRepositorio;

    public TipoPrenda guardarTipoPrenda(TipoPrenda datosTipoPrenda)throws Exception{
        try{
            if (validacionTipoPrenda.validarNombre(datosTipoPrenda.getNombre())){
                return tipoPrendaRepositorio.save(datosTipoPrenda);

            }return null;
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public TipoPrenda consultarTipoPrendaId(Integer idTipoPrenda)throws Exception{
       try{
           if (tipoPrendaRepositorio.findById(idTipoPrenda).isPresent()){
               return tipoPrendaRepositorio.findById(idTipoPrenda).get();
           }else{
               throw new Exception("Tipo prenda no encontrado");
           }
       }catch (Exception error){
           throw new Exception(error.getMessage());
       }
    }

    public List<TipoPrenda> buscarTodosTipoPrenda()throws Exception{
        try{
            return tipoPrendaRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public TipoPrenda editarTipoPrenda(){
        return null;
    }
    public boolean eliminarTipoPrenda(){
        return true;
    }

}
