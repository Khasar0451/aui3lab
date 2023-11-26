package com.example.weapon.service;

import com.example.weapon.entity.Weapon;
import com.example.weapon.repository.WeaponRepo;
import com.example.dwarf.service.DwarfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WeaponService {
    public WeaponRepo weaponRepo;
    public DwarfService dwarfService;

    @Autowired
    WeaponService(WeaponRepo w, DwarfService d){
        weaponRepo = w; dwarfService = d;
    }

    public List<Weapon> findByDwarf(UUID uuid) {
        return dwarfService.find(uuid).map(weaponRepo::findByDwarf).get();
    }
    public List<Weapon> findAll(){
        return weaponRepo.findAll();
    }

    public void create(Weapon weapon){
        weaponRepo.save(weapon);
    }
    public void update(Weapon weapon){
        weaponRepo.save(weapon);
    }

    public Optional<Weapon> find(String name){
        return (weaponRepo.findByName(name));
    }

    public Optional<Weapon> find(UUID uuid){
        return (weaponRepo.findByUuid(uuid));
    }

    public void delete(UUID uuid){
        weaponRepo.findByUuid(uuid).ifPresent(weaponRepo::delete);
    }
    public void delete(String name){
        weaponRepo.findByName(name).ifPresent(weaponRepo::delete);
    }

}
