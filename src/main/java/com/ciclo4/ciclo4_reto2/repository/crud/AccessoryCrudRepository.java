package com.ciclo4.ciclo4_reto2.repository.crud;

import com.ciclo4.ciclo4_reto2.model.Accessory;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AccessoryCrudRepository extends MongoRepository<Accessory, String> {
}

