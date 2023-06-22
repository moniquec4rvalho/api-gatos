package com.example.gatos.controller;

import com.example.gatos.model.Cat;
import com.example.gatos.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cat")
public class CatController {

    @Autowired
    CatService catService;

    @PostMapping
    private Cat createCat(@RequestBody Cat request) {
        Cat saveCat = catService.createCat(request);
        return saveCat;
    }

    @GetMapping
    private List<Cat> getAll(@Param("name") String name) {

        return catService.getAllCats(name);

    }

    @GetMapping("/{id}")
    private Cat getById(@PathVariable("id") String id) {
        Cat cat = catService.getCatById(id);
        return cat;
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable("id") String id){
        catService.removeCat(id);
    }

    @PutMapping
    public Cat updateCat (@RequestBody Cat request) {
        Cat update = catService.update(request);
        return update;
    }
}
