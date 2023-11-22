package com.example.aui2.controller;
import com.example.aui2.dto.*;
import com.example.aui2.functions.DwarfToResponseFunction;
import com.example.aui2.functions.DwarvesToResponseFunction;
import com.example.aui2.functions.RequestToDwarfFunction;
import com.example.aui2.functions.UpdateDwarfWithRequestFunction;
import com.example.aui2.service.DwarfService;

import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
@RestController
@Log
public class DwarfDefaultController {


    private final DwarfService service;
    private final DwarfToResponseFunction dwarfToResponseFunction;
    private final DwarvesToResponseFunction dwarvesToResponseFunction;
    private final RequestToDwarfFunction requestToDwarfFunction;
    private final UpdateDwarfWithRequestFunction updateDwarfWithRequestFunction;

    public DwarfDefaultController(DwarfService service, DwarfToResponseFunction dwarfToResponseFunction, DwarvesToResponseFunction dwarvesToResponseFunction, RequestToDwarfFunction requestToDwarfFunction, UpdateDwarfWithRequestFunction updateDwarfWithRequestFunction) {
        this.service = service;
        this.dwarfToResponseFunction = dwarfToResponseFunction;
        this.dwarvesToResponseFunction = dwarvesToResponseFunction;
        this.requestToDwarfFunction = requestToDwarfFunction;
        this.updateDwarfWithRequestFunction = updateDwarfWithRequestFunction;
    }
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/drg/dwarves")
    public GetDwarvesResponse getDwarves() {
        if (service.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return dwarvesToResponseFunction.apply(service.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/drg/dwarves/{uuid}")
    public GetDwarfResponse getDwarf(@PathVariable UUID uuid) {
        return service.find(uuid)
                .map(dwarfToResponseFunction)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/drg/dwarves/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void putDwarf(@PathVariable UUID id, @RequestBody PutDwarfRequest request) throws Exception {
        try {
            service.create(requestToDwarfFunction.apply(id, request));
        }
        catch (Exception exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/drg/dwarves/{id}")
    public void patchWeapon(@PathVariable UUID id, @RequestBody PatchDwarfRequest request){
        service.find(id)
                .ifPresentOrElse(
                        dwarf -> service.update(updateDwarfWithRequestFunction.apply(dwarf, request)),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );
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
