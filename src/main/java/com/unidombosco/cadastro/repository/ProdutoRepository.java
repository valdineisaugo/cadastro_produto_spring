package com.unidombosco.cadastro.repository;

import com.unidombosco.cadastro.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // opcional: buscar por código único
    boolean existsByCodigo(String codigo);
}
