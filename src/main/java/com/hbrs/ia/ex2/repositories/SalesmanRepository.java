package com.hbrs.ia.ex2.repositories;

import com.hbrs.ia.ex2.model.Salesman;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalesmanRepository extends MongoRepository<Salesman, String> {
    Salesman findSalesmanBySid(int sid);
}