package com.banco.bnaco.erik.dto;

import jakarta.validation.constraints.NotBlank;

public class ClienteDTO {

    @NotBlank
    private String nome_cliente;

    @NotBlank
    private String numero_cpf;

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getNumero_cpf() {
        return numero_cpf;
    }

    public void setNumero_cpf(String numero_cpf) {
        this.numero_cpf = numero_cpf;
    }
}
