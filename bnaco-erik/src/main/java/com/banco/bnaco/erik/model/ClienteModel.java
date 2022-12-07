package com.banco.bnaco.erik.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "clientes")
public class ClienteModel implements Serializable {

    private final long  serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false,unique = false,length = 100)
    private String nome_cliente;

    @Column(nullable = false,unique = true,length = 15)
    private String numero_cpf;


    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
