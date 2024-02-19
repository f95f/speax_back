package com.C.speaxs.domain.repository;

import com.C.speaxs.domain.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LanguageRepository extends JpaRepository<Language, UUID> {
    Optional<Language> findByLanguage(String language);
}
