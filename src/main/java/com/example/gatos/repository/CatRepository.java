package com.example.gatos.repository;

import com.example.gatos.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository <Cat,String> {

    List<Cat> findAllByNameContainsIgnoreCase(String name);

}


//somente para extender o JPA para o projeto//