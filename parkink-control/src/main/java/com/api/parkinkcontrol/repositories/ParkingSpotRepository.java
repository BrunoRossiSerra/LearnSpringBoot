package com.api.parkinkcontrol.repositories;

import com.api.parkinkcontrol.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkingSpotRepository extends
        JpaRepository<ParkingSpotModel, UUID> {

    public boolean exists
    public boolean existsByLicensePlateCar(String licensePlateCar);
    public boolean existsByParkingSpotNumber(String parkingSpotNumber);

    public boolean existsByApartmentAndBloco(String apartment, String bloco);
}

