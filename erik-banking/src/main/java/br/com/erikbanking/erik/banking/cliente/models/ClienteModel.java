package br.com.erikbanking.erik.banking.cliente.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "cliente")
public class ClienteModel implements Serializable {

    private final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column (nullable = false, unique = true, length = 100)
    private String nome;

    @Column(nullable = false,unique = true, length = 11)
    private String cpf;



}
