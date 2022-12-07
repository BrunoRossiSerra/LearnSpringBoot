package com.banco.bnaco.erik.repository;

import com.banco.bnaco.erik.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository
        <ClienteModel, UUID> {
}
