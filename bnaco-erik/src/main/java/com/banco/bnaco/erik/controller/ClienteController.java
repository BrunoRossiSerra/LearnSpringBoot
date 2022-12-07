package com.banco.bnaco.erik.controller;

import com.banco.bnaco.erik.dto.ClienteDTO;
import com.banco.bnaco.erik.model.ClienteModel;
import com.banco.bnaco.erik.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/clientes")
public class ClienteController {

    final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }
    @PostMapping
    public ResponseEntity<Object>saveCliente(@RequestBody @Valid
                                             ClienteDTO clienteDTO){
    var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDTO,clienteModel);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(clienteService.save(clienteModel));

    }


}
