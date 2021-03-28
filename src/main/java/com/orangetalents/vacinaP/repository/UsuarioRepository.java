package com.orangetalents.vacinaP.repository;

import com.orangetalents.vacinaP.model.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
    List<Usuario> findByNameIgnoreCaseContaining (String nome);
}
