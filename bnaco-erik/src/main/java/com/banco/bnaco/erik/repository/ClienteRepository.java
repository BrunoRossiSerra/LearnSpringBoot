package com.banco.bnaco.erik.repository;

import com.banco.bnaco.erik.model.ClienteModel;
import com.banco.bnaco.erik.service.ClienteService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository
        <ClienteModel, UUID> {

}


