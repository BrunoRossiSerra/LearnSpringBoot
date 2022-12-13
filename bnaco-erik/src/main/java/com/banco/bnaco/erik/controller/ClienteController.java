package com.banco.bnaco.erik.controller;

import com.banco.bnaco.erik.dto.ClienteDTO;
import com.banco.bnaco.erik.model.ClienteModel;
import com.banco.bnaco.erik.repository.ClienteRepository;
import com.banco.bnaco.erik.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/clientes")
public class ClienteController {

    final ClienteService clienteService;
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteService clienteService,
                             ClienteRepository clienteRepository) {
        this.clienteService = clienteService;
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    public ResponseEntity<Object>saveCliente(@RequestBody @Valid
                                             ClienteDTO clienteDTO){
         var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDTO,clienteModel);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(clienteService.save(clienteModel));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCliente(
            @PathVariable (value = "id") UUID id ){
        Optional<ClienteModel> clienteModelOptional = clienteService
                .findByIId(id);
        if(!clienteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Parkink spot not found");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(clienteModelOptional.get());
    }

    @GetMapping
    public ResponseEntity<Page<ClienteModel>> getAllClientes
            (@PageableDefault (page=0,size = 10,
            sort = "id",direction = Sort.Direction.ASC)Pageable pageable){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(clienteService.findAll(pageable));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOneCliente(
            @PathVariable (value = "id") UUID id ){
        Optional<ClienteModel> clienteModelOptional = clienteService
                .findByIId(id);
        if(!clienteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Parkink spot not found");
        }

        clienteService.delete(clienteModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK)
                .body("Parking Spot  deleted successefuly");


    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParkingSpot
            (@PathVariable (value = "id")
             UUID id,@RequestBody @Valid ClienteDTO
                     clienteDTO) {
        Optional<ClienteModel> clienteModelOptional = clienteService
                .findByIId(id);
        if(!clienteModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("não tem cliente ");
        }

        var clienteModel = new ClienteModel();
        BeanUtils.copyProperties(clienteDTO,clienteModel);
        clienteModel.setId(clienteModelOptional.get().getId());


        return ResponseEntity.status(HttpStatus.OK)
                .body(clienteService.save(clienteModel));

}}
