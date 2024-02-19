package com.C.speaxs.domain.service;

import com.C.speaxs.domain.model.Location;
import com.C.speaxs.domain.model.User;
import com.C.speaxs.domain.repository.LanguageRepository;
import com.C.speaxs.domain.repository.LocationRepository;
import com.C.speaxs.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;
    private final LocationRepository locationRepository;
    private final LanguageRepository languageRepository;

    @Transactional
    public User saveUser(User user){

        if(!isUserUnique(user)){
            throw new RuntimeException("Deu errado.");
        }

        Optional<Location> birthLocation = Optional.ofNullable(user.getBirthLocation());
        if (birthLocation.isPresent()) {
            user.setBirthLocation(saveLocation(birthLocation.get()));
        }

        Optional<Location> currentLocation = Optional.ofNullable(user.getCurrentLocation());
        if (currentLocation.isPresent()) {
            user.setCurrentLocation(saveLocation(currentLocation.get()));
        }

        return repository.save(user);
    }
    private boolean isUserUnique(User user){
        boolean isPhoneTaken = repository.findByPhone(user.getPhone()).isPresent();
        boolean isEmailTaken = repository.findByEmail(user.getEmail()).isPresent();

        return !(isEmailTaken || isPhoneTaken);
    }
    private Location saveLocation(Location location){
        Optional<Location> locationToRegister = locationRepository
                .findByCountry(location.getCountry())
                .filter(item -> !item.equals(location));

        if(locationToRegister.isPresent()){
            return locationToRegister.get();
        }
        else{
            return this.locationRepository.save(location);
        }
    }

    public List<User> listUsers() {
        return repository.findAll();
    }

    public Optional<User> findById(UUID id) {
        return repository.findById(id);
    }

    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
