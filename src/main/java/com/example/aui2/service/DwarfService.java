package com.example.aui2.service;

import com.example.aui2.entity.Dwarf;
import com.example.aui2.entity.Weapon;
import com.example.aui2.repository.DwarfRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DwarfService {
    public DwarfRepo dwarfRepo;

    @Autowired
    DwarfService(DwarfRepo dwarfRepo){
        this.dwarfRepo = dwarfRepo;
    }

    public void create(Dwarf dwarf){
        dwarfRepo.save(dwarf);
    }
    public void update(Dwarf dwarf){
        dwarfRepo.save(dwarf);
    }

    public Optional<Dwarf> find(String name){
        return dwarfRepo.findByName(name);
    }
    public Optional<Dwarf> find(UUID uuid){
        return dwarfRepo.findByUuid(uuid);
    }
    public List<Weapon> findWeaponsByDwarf(String name) {
        return dwarfRepo.findByName(name).get().getWeapons();
    }

    public List<Dwarf> findAll(){
        return dwarfRepo.findAll();
    }
    public void delete(UUID uuid){
        dwarfRepo.findByUuid(uuid).ifPresent(dwarfRepo::delete);
    }

}
