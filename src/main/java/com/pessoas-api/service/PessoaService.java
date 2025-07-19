package com.seuprojeto.service;

import com.seuprojeto.dto.PessoaDTO;
import com.seuprojeto.model.Pessoa;
import com.seuprojeto.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaDTO criarPessoa(PessoaDTO dto) {
        if (pessoaRepository.existsByCpf(dto.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado.");
        }

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        pessoa.setCpf(dto.getCpf());
        pessoa.setDataNascimento(dto.getDataNascimento());

        Pessoa salva = pessoaRepository.save(pessoa);
        return toDTO(salva);
    }

    public Optional<PessoaDTO> buscarPorCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf).map(this::toDTO);
    }

    private PessoaDTO toDTO(Pessoa pessoa) {
        PessoaDTO dto = new PessoaDTO();
        dto.setId(pessoa.getId());
        dto.setNome(pessoa.getNome());
        dto.setCpf(pessoa.getCpf());
        dto.setDataNascimento(pessoa.getDataNascimento());
        return dto;
    }
}