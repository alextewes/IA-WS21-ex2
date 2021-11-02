package com.hbrs.ia.ex2.controller;

import com.hbrs.ia.ex2.model.Salesman;
import com.hbrs.ia.ex2.repositories.SalesmanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

//enabling Cors https://www.baeldung.com/spring-cors
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class SalesmanController {

    @Autowired
    SalesmanRepository salesmanRepository;

    @GetMapping("/")
    public String index() {
        return "Salesman API Works";
    }

    @GetMapping("/api/salesmen/{id}")
    public Salesman getSalesman(@PathVariable int id) {
        return salesmanRepository.findSalesmanBySid( id);
    }
    @GetMapping("/api/salesmen")
    public List<Salesman> getSalesmen() {
        return salesmanRepository.findAll();
    }
    @PostMapping("/api/salesmen")
    public Salesman createSalesman(@Valid @RequestBody Salesman salesman){
        salesmanRepository.insert(salesman);
        return salesman;
    }
    @PatchMapping("/api/salesmen")
    public Salesman updateSalesman(@Valid @RequestBody Salesman salesman){
        Salesman s = salesmanRepository.findSalesmanBySid( salesman.getSid());
        s.setFirstName(salesman.getFirstName());
        s.setLastName(salesman.getLastName());
        salesmanRepository.save(s);
        return s;
    }
    @DeleteMapping("/api/salesmen/{sid}")
    public Salesman deleteSalesman(@PathVariable int sid){
        Salesman s = salesmanRepository.findSalesmanBySid( sid);
        salesmanRepository.deleteById("" + sid);
        return s;
    }
}
