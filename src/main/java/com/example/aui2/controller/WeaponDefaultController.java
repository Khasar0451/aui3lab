package com.example.aui2.controller;
import com.example.aui2.dto.GetWeaponResponse;
import com.example.aui2.dto.GetWeaponsResponse;
import com.example.aui2.dto.PatchWeaponRequest;
import com.example.aui2.dto.PutWeaponRequest;
import com.example.aui2.entity.Weapon;
import com.example.aui2.functions.RequestToWeaponFunction;
import com.example.aui2.functions.UpdateWeaponWithRequestFunction;
import com.example.aui2.functions.WeaponToResponseFunction;
import com.example.aui2.functions.WeaponsToResponseFunction;
import com.example.aui2.service.WeaponService;
import lombok.extern.java.Log;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController

public class WeaponDefaultController {
    private final WeaponService service;
    private final WeaponToResponseFunction weaponToResponseFunction;
    private final WeaponsToResponseFunction weaponsToResponseFunction;
    private final RequestToWeaponFunction requestToWeaponFunction;
    private final UpdateWeaponWithRequestFunction updateWeaponWithRequestFunction;

    public WeaponDefaultController(WeaponService weaponService, WeaponToResponseFunction weaponToResponseFunction, WeaponsToResponseFunction weaponsToResponseFunction, RequestToWeaponFunction requestToWeaponFunction, UpdateWeaponWithRequestFunction updateWeaponWithRequestFunction) {
        this.service = weaponService;
        this.weaponToResponseFunction = weaponToResponseFunction;
        this.weaponsToResponseFunction = weaponsToResponseFunction;
        this.requestToWeaponFunction = requestToWeaponFunction;
        this.updateWeaponWithRequestFunction = updateWeaponWithRequestFunction;
    }
    @GetMapping("drg/weapons")
    public GetWeaponsResponse getWeapons(){
        return weaponsToResponseFunction.apply(service.findAll());
    }

    @GetMapping("/drg/dwarves/{uuid}/weapons")
    public GetWeaponsResponse getWeaponsByDwarf(@PathVariable UUID uuid){
        List<Weapon> weaponList = null;
        try {
            weaponList = service.findByDwarf(uuid);
            if (weaponList.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NO_CONTENT);
            }
            return weaponsToResponseFunction.apply(service.findByDwarf(uuid));
        }
        catch(Exception e) {
            if (weaponList.isEmpty())
                throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return null;
    }


    @GetMapping("/drg/weapons/{uuid}")
    public GetWeaponResponse getWeaponByName(@PathVariable UUID uuid) {
        return service.find(uuid)
                .map(weaponToResponseFunction)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/drg/weapons/{id}")
    public void patchWeapon(@PathVariable UUID id, @RequestBody PatchWeaponRequest request){
        service.find(id)
                        .ifPresentOrElse(
                                weapon -> service.update(updateWeaponWithRequestFunction.apply(weapon, request)),
                                () -> {
                                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                                }
                        );
    }
    @PutMapping("/drg/weapons/{id}")
    @ResponseStatus(HttpStatus.CREATED)

    public void putWeapon(@PathVariable UUID id, @RequestBody PutWeaponRequest request) throws Exception {
       try {
           service.create(requestToWeaponFunction.apply(id, request));
       }
    catch (Exception exception){
           System.out.println(id);
           throw new Exception(exception);
            //throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/drg/weapons/{id}")
    public void deleteWeapon(@PathVariable UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        dwarf -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
