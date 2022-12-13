package com.banco.bnaco.erik.service;

import com.banco.bnaco.erik.model.ClienteModel;
import com.banco.bnaco.erik.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository= clienteRepository;
    }

    public Optional<ClienteModel> findByIId(UUID id) {
        return clienteRepository.findById(id);
    }

    public Page<ClienteModel> findAll(Pageable pageable){
        return clienteRepository.findAll(pageable);
    }


    @Transactional
    public ClienteModel save(ClienteModel clienteModel) {
        return clienteRepository.save(clienteModel);
    }


}
