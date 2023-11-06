package com.example.aui2.controller;
import com.example.aui2.dto.GetWeaponResponse;
import com.example.aui2.dto.GetWeaponsResponse;
import com.example.aui2.dto.PatchWeaponRequest;
import com.example.aui2.dto.PutWeaponRequest;
import com.example.aui2.functions.RequestToWeaponFunction;
import com.example.aui2.functions.UpdateWeaponWithRequestFunction;
import com.example.aui2.functions.WeaponToResponseFunction;
import com.example.aui2.functions.WeaponsToResponseFunction;
import com.example.aui2.service.WeaponService;
import lombok.extern.java.Log;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log
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

    @GetMapping("drg/weapons/{dwarfName}")
    public GetWeaponsResponse getWeaponsByDwarf(@PathVariable String dwarfName){
        return weaponsToResponseFunction.apply(service.findByDwarf(dwarfName));
    }

    @GetMapping("drg/weapons/{name}")
    public GetWeaponResponse getWeaponByName(@PathVariable String name) {
        return service.find(name)
                .map(weaponToResponseFunction)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("drg/weapons")
    public void patchWeapon(@RequestBody PatchWeaponRequest request){
        service.find(request.getName())
                        .ifPresentOrElse(
                                weapon -> service.update(updateWeaponWithRequestFunction.apply(weapon, request)),
                                () -> {
                                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                                }
                        );
    }
    @PutMapping("/drg/weapons/{id}")
    public void putWeapon(@PathVariable UUID id, @RequestBody PutWeaponRequest request) {
        service.create(requestToWeaponFunction.apply(id, request));
    }
//    @DeleteMapping("/drg/weapons/{id}")
//    public void deleteWeapon(@PathVariable UUID id) {
//        service.find(id)
//                .ifPresentOrElse(
//                        dwarf -> service.delete(id),
//                        () -> {
//                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//                        }
//                );
//    }
    @DeleteMapping("/drg/weapons/{name}")
    public void deleteWeapon(@PathVariable String name) {
        service.find(name)
                .ifPresentOrElse(
                        dwarf -> service.delete(name),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }

}
