package com.ciclo4.ciclo4_reto2.web;

import com.ciclo4.ciclo4_reto2.model.Accessory;
import com.ciclo4.ciclo4_reto2.service.AccessoryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accessory")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AccessoryController {
    @Autowired
    private AccessoryService accessoryService;

    @GetMapping("/all")
    public List<Accessory> getAll(){
        return accessoryService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Accessory> getCleaningAccessory(@PathVariable("reference") String reference) {
        return accessoryService.getCleaningAccessories(reference);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Accessory accessory){
        accessoryService.save(accessory);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Accessory update(@RequestBody Accessory accessory){
        return accessoryService.update(accessory);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference){
        return accessoryService.delete(reference);
    }
}

