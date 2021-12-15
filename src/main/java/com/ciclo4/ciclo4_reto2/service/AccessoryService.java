package com.ciclo4.ciclo4_reto2.service;

import com.ciclo4.ciclo4_reto2.model.Accessory;
import com.ciclo4.ciclo4_reto2.repository.AccessoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessoryService {
    @Autowired
    private AccessoryRepository accessoryRepository;

    public List<Accessory> getAll(){
        return accessoryRepository.getAll();
    }

    public Optional<Accessory> getCleaningAccessories(String reference){
        return accessoryRepository.getAccessory(reference);
    }

    public Accessory save(Accessory cleaningAccessory){
        if (cleaningAccessory.getReference()== null){
            return cleaningAccessory;
        }else{
            return accessoryRepository.create(cleaningAccessory);
        }
    }

    public Accessory update(Accessory accessory){
        if (accessory.getReference()!= null){
            Optional<Accessory> dbAccessory = accessoryRepository.getAccessory(accessory.getReference());
            if (!dbAccessory.isEmpty()){
                if (accessory.getBrand()!= null){
                    dbAccessory.get().setBrand(accessory.getBrand());
                }
                if (accessory.getCategory()!= null){
                    dbAccessory.get().setCategory(accessory.getCategory());
                }
                if (accessory.getMaterial()!= null){
                    dbAccessory.get().setMaterial(accessory.getMaterial());
                }
                if (accessory.getGender()!= null){
                    dbAccessory.get().setGender(accessory.getGender());
                }
                if (accessory.getSize()!= null){
                    dbAccessory.get().setSize(accessory.getSize());
                }
                if (accessory.getDescription() != null){
                    dbAccessory.get().setDescription(accessory.getDescription());
                }

                dbAccessory.get().setAvailability(accessory.isAvailability());

                if (accessory.getPrice()!= 0.0){
                    dbAccessory.get().setPrice(accessory.getPrice());
                }
                if (accessory.getQuantity()!= 0){
                    dbAccessory.get().setQuantity(accessory.getQuantity());
                }
                if (accessory.getPhotography()!= null){
                    dbAccessory.get().setPhotography(accessory.getPhotography());
                }
                accessoryRepository.update(dbAccessory.get());
                return dbAccessory.get();
            } else {
                return accessory;
            }
        } else {
            return accessory;
        }
    }

    public boolean delete(String reference){
        Boolean aboolean = getCleaningAccessories(reference).map(cleaningAccessory -> {
            accessoryRepository.delete(cleaningAccessory);
            return true;
        }).orElse(false);
        return aboolean;
    }
}
