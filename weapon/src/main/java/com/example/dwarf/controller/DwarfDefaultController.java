package com.example.dwarf.controller;

import com.example.dwarf.entity.Dwarf;
import com.example.dwarf.service.DwarfService;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
@RestController
@Log
public class DwarfDefaultController {
    private final DwarfService service;
    @Autowired
    public DwarfDefaultController(DwarfService service){
        this.service = service;
    }

    @PutMapping("/drg/dwarves/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void putDwarf(@PathVariable UUID id, @RequestBody Dwarf dwarf) throws Exception {
        try {
            service.create(dwarf);
        }
        catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/drg/dwarves/{id}")
    public void deleteDwarf(@PathVariable UUID id) {
        service.find(id)
                .ifPresentOrElse(
                        dwarf -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
    }
}
