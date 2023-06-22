package com.example.gatos.service;

import com.example.gatos.model.Cat;
import com.example.gatos.repository.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CatService {
    @Autowired
    private CatRepository catRepository;

    public Cat createCat(Cat request) {
        request.setId(UUID.randomUUID().toString());
        Cat savedCat = catRepository.save(request);
        return savedCat;
    }

    public List<Cat> getAllCats(String name) {

        if ( name == null || name == "") {
            List<Cat> listCats = catRepository.findAll();
            return listCats;
        } else {
            List<Cat> listCats = catRepository.findAllByNameContainsIgnoreCase(name);
            return listCats;
        }

    }

    public Cat getCatById(String id) {
        Optional<Cat> cat = catRepository.findById(id);
        if (cat.isPresent()) {
            return cat.get();
        } else {
            throw new RuntimeException("Não encontrado");
        }
    }

    public void removeCat (String id){
        Optional<Cat> cat = catRepository.findById(id);
        if (cat.isPresent()) {
            catRepository.deleteById(id);

        } else {
            throw new RuntimeException("Não encontrado");
        }
    }

    public Cat update(Cat request){
        Optional<Cat> cat = catRepository.findById(request.getId());
        Cat savedCat;

        if (cat.isPresent()) {
           savedCat = catRepository.save(request);

        } else {
            throw new RuntimeException("Não encontrado");
        }

        return savedCat;
    }

}
