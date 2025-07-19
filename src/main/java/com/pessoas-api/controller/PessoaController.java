package com.seuprojeto.controller;

import com.seuprojeto.dto.PessoaDTO;
import com.seuprojeto.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaDTO> criarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
        PessoaDTO novaPessoa = pessoaService.criarPessoa(pessoaDTO);
        return new ResponseEntity<>(novaPessoa, HttpStatus.CREATED);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<PessoaDTO> buscarPorCpf(@PathVariable String cpf) {
        return pessoaService.buscarPorCpf(cpf)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}