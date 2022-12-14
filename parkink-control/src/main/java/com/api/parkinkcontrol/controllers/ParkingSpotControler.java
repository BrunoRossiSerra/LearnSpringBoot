package com.api.parkinkcontrol.controllers;

import com.api.parkinkcontrol.dtos.ParkingSpotDTO;
import com.api.parkinkcontrol.models.ParkingSpotModel;
import com.api.parkinkcontrol.services.ParkinSpotService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotControler {

    final ParkinSpotService parkinSpotService;
    public ParkingSpotControler(ParkinSpotService parkinSpotService) {

        this.parkinSpotService = parkinSpotService;
    }

    @PostMapping
    public ResponseEntity<Object> saveSpotParking(@RequestBody @Valid ParkingSpotDTO
                                                  parkingSpotDTO){

        if(parkinSpotService.existsByLicensePlateCar(parkingSpotDTO.getLicensePlateCar())){
         return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflito");
        }
        if(parkinSpotService.existsByParkingSpotNumber(parkingSpotDTO.getParkingSpotNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflituoso");
        }
        if(parkinSpotService.existsByApartmentAndBlook(parkingSpotDTO.getApartment(),
                parkingSpotDTO.getBloco())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflituoso");
        }
        var parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDTO,parkingSpotModel);
        parkingSpotModel.setRegistrationDate(LocalDateTime.now(
               ZoneId.of("UTC") ));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(parkinSpotService.save(parkingSpotModel));

    }
    @GetMapping
      public ResponseEntity<Page<ParkingSpotModel>>getAllParkingSpots(
            @PageableDefault (page =0, size = 10,
            sort = "id",direction = Sort.Direction.ASC)Pageable pageable){
       return ResponseEntity.status(HttpStatus.OK)
                .body(parkinSpotService.findAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneParkingSpot(
            @PathVariable (value = "id") UUID id ){
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkinSpotService
                .findByIId(id);
        if(!parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Parkink spot not found");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(parkingSpotModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOneParkingSpot(
            @PathVariable (value = "id") UUID id ){
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkinSpotService
                .findByIId(id);
        if(!parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Parkink spot not found");
        }

        parkinSpotService.delete(parkingSpotModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK)
                .body("Parking Spot  deleted successefuly");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateParkingSpot
            (@PathVariable (value = "id")
             UUID id,@RequestBody @Valid ParkingSpotDTO
             parkingSpotDTO) {
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkinSpotService
            .findByIId(id);
        if(!parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Parkink spot not found");
        }

        var parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDTO,parkingSpotModel);
        parkingSpotModel.setId(parkingSpotModelOptional.get().getId());
        parkingSpotModel.setRegistrationDate(
                parkingSpotModelOptional.get()
                        .getRegistrationDate());

        return ResponseEntity.status(HttpStatus.OK)
                .body(parkinSpotService.save(parkingSpotModel));
        /*parkingSpotModel.setParkingSpotNumber(parkingSpotDTO.getParkingSpotNumber());
        parkingSpotModel.setModelCar(parkingSpotDTO.getModelCar());
        parkingSpotModel.setBrandCar(parkingSpotDTO.getBrandCar());
        parkingSpotModel.setLicensePlateCar(parkingSpotDTO.getLicensePlateCar());
        parkingSpotModel.setColorCar(parkingSpotDTO.getColorCar());
        parkingSpotModel.setApartment(parkingSpotDTO.getApartment());
        parkingSpotModel.setBloco(parkingSpotDTO.getBloco());*/



    }










}
