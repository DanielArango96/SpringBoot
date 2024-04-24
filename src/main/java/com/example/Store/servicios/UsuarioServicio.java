package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionUsuario;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {

    //en los servicios debo inyectar las dependencias de las validaciones y las consultas o repositorios
    @Autowired
    ValidacionUsuario validacionUsuario;
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    //  en el servicio se creanun metodo para cada una de las consultas a realizar en BD


    // metodo para guardar un usuario, metodo para consultar un usuario en bd por id , metodo para consultar todos los usuarios,
    // metodo para editar un usuario, metodo para eliminar un usuario.

    public Usuario guardarUsuario(Usuario datosUsuario) throws Exception{
        try {
            if (validacionUsuario.validarUsuario(datosUsuario)) { // si pasa las validaciones lo guarda
                return usuarioRepositorio.save(datosUsuario);
            }
            return null; // Mover el retorno dentro del bloque if
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }
    public Usuario consultarUsuarioId(Integer idUsuario)throws Exception{
        try{
            if (usuarioRepositorio.findById(idUsuario).isPresent()){
                return usuarioRepositorio.findById(idUsuario).get();

            }else{
                throw new Exception("usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }

    }

    public List<Usuario> buscarTodosUsuarios()throws Exception{
        try{
            return usuarioRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Usuario editarUsuario(){
        return null;
    }
    public boolean eliminarUsuario(){
        return true;
    }

}
