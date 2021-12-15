package com.ciclo4.ciclo4_reto2.repository;

import com.ciclo4.ciclo4_reto2.model.Accessory;
import com.ciclo4.ciclo4_reto2.repository.crud.AccessoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccessoryRepository {
    @Autowired
    private AccessoryCrudRepository accessoryCrudRepository;

    public List<Accessory> getAll(){
        return accessoryCrudRepository.findAll();
    }

    public Optional<Accessory> getAccessory(String id){
        return accessoryCrudRepository.findById(id);
    }

    public Accessory create(Accessory accessory){
        return accessoryCrudRepository.save(accessory);
    }

    public void update(Accessory accessory){
        accessoryCrudRepository.save(accessory);
    }

    public void delete(Accessory accessory){
        accessoryCrudRepository.delete(accessory);
    }
}
