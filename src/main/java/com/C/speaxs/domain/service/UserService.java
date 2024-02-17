package com.C.speaxs.domain.service;

import com.C.speaxs.domain.model.User;
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

    @Transactional
    public User saveUser(User user){

        boolean isPhoneTaken = repository.findByPhone(user.getPhone())
                .filter(item -> !item.equals(user))
                .isPresent();
        boolean isEmailTaken = repository.findByEmail(user.getEmail())
                .filter(item -> !item.equals(user))
                .isPresent();

        if(isEmailTaken || isPhoneTaken){
            throw new RuntimeException("Deu errado.");
        }

        return repository.save(user);
    }

    public List<User> listUsers() {
        return repository.findAll();
    }

    public Optional<User> findById(UUID id) {
        return repository.findById(id);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
