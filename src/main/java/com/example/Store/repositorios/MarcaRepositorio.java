package com.example.Store.repositorios;

import com.example.Store.modelos.Marca;
import com.example.Store.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepositorio extends JpaRepository<Marca,Integer> {
}
