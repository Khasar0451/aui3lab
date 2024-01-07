package com.example.weapon.controller;
import com.example.weapon.entity.Weapon;

import com.example.weapon.dto.GetWeaponResponse;
import com.example.weapon.dto.GetWeaponsResponse;
import com.example.weapon.dto.PatchWeaponRequest;
import com.example.weapon.dto.PutWeaponRequest;

import com.example.weapon.functions.RequestToWeaponFunction;
import com.example.weapon.functions.UpdateWeaponWithRequestFunction;
import com.example.weapon.functions.WeaponToResponseFunction;
import com.example.weapon.functions.WeaponsToResponseFunction;
import com.example.dwarf.service.DwarfService;
import com.example.weapon.service.WeaponService;

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

    public WeaponDefaultController(WeaponService weaponService, DwarfService dwarfservice, WeaponToResponseFunction weaponToResponseFunction, WeaponsToResponseFunction weaponsToResponseFunction, RequestToWeaponFunction requestToWeaponFunction, UpdateWeaponWithRequestFunction updateWeaponWithRequestFunction) {
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
    @GetMapping("drg/weapons/{uuid}")
    public GetWeaponResponse getWeapon(@PathVariable UUID uuid){
        return service.find(uuid)
                .map(weaponToResponseFunction)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/drg/dwarves/{uuid}/weapons")
    public GetWeaponsResponse getWeaponsByDwarf(@PathVariable UUID uuid) {
        List<Weapon> weapons;
        try{
            weapons = service.findByDwarf(uuid);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (weapons.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return weaponsToResponseFunction.apply(weapons);
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
    @PatchMapping("/drg/dwarves/{idDwarf}/weapons/{idWeapon}")
    public void patchWeapon(@PathVariable UUID idDwarf,@PathVariable UUID idWeapon, @RequestBody PatchWeaponRequest request){
        request.setUUIDdwarf(idDwarf);
        service.find(idWeapon)
                        .ifPresentOrElse(
                                weapon -> service.update(updateWeaponWithRequestFunction.apply(weapon, request)),
                                () -> {
                                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                                }
                        );
    }
    @PutMapping("/drg/weapons/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void putWeapon(@PathVariable String id, @RequestBody PutWeaponRequest request) throws Exception {
       try {
           service.create(requestToWeaponFunction.apply(UUID.fromString(id), request));
       }
    catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/drg/weapons/{id}")
    public void deleteWeapon(@PathVariable UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        weapon -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
