package com.api.parkinkcontrol.services;

import com.api.parkinkcontrol.models.ParkingSpotModel;
import com.api.parkinkcontrol.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkinSpotService {

    final ParkingSpotRepository parkingSpotRepository;


    public ParkinSpotService(ParkingSpotRepository parkingSpotRepository){
        this.parkingSpotRepository = parkingSpotRepository;
    }


    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }
    public boolean existsByLicensePlateCar(String licensePlateCar) {
     return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }
    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlook(String apartment, String blook) {
        return parkingSpotRepository.existsByApartmentAndBloco(apartment,blook);
    }

    public Page<ParkingSpotModel> findAll(Pageable pageable){
             return parkingSpotRepository.findAll(pageable);
    }

    public Optional<ParkingSpotModel> findByIId(UUID id) {
        return parkingSpotRepository.findById(id);
    }

    @Transactional
    public void delete(ParkingSpotModel parkingSpotModel) {
         parkingSpotRepository.delete(parkingSpotModel);
    }


}
