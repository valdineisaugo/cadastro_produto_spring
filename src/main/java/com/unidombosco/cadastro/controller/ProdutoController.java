package com.unidombosco.cadastro.controller;

import com.unidombosco.cadastro.model.Produto;
import com.unidombosco.cadastro.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable Long id) {
        return produtoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Produto> criar(@Valid @RequestBody Produto produto) {
        if (produtoRepository.existsByCodigo(produto.getCodigo())) {
            return ResponseEntity.badRequest().build();
        }
        Produto salvo = produtoRepository.save(produto);
        return ResponseEntity.ok(salvo);
    }
}
