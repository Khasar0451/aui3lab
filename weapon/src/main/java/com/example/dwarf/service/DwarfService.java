package com.example.dwarf.service;

import com.example.dwarf.entity.Dwarf;
import com.example.weapon.entity.Weapon;
import com.example.dwarf.repository.DwarfRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DwarfService {
    public DwarfRepo dwarfRepo;

    @Autowired
    public DwarfService(DwarfRepo dwarfRepo){
        this.dwarfRepo = dwarfRepo;
    }

    public void create(Dwarf dwarf){
        dwarfRepo.save(dwarf);
    }
    public void update(Dwarf dwarf){
        dwarfRepo.save(dwarf);
    }

    public Optional<Dwarf> find(UUID uuid){
        return dwarfRepo.findById(uuid);
    }
//    public List<Weapon> findWeaponsByDwarf(UUID id) {
//        return dwarfRepo.findById(id).get().getWeapons();
//    }
//
//    public List<Dwarf> findAll(){
//        return dwarfRepo.findAll();
//    }
    public void delete(UUID uuid){
        dwarfRepo.findById(uuid).ifPresent(dwarfRepo::delete);
    }

}
