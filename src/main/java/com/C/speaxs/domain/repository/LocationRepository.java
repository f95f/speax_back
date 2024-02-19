package com.C.speaxs.domain.repository;

import com.C.speaxs.domain.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LocationRepository extends JpaRepository<Location, UUID> {
    Optional<Location> findByCity(String city);
    Optional<Location> findByCountry(String country);

}
