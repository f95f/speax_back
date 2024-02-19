package com.C.speaxs.api.controller;

import com.C.speaxs.domain.model.Language;
import com.C.speaxs.domain.repository.LanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/languages")
public class LanguageController {

    private final LanguageRepository repository;

    @GetMapping
    public List<Language> listAllLanguages(){ return repository.findAll(); }

}
