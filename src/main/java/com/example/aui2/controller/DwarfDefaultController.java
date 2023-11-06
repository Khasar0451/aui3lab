package com.example.aui2.controller;
import com.example.aui2.dto.GetDwarfResponse;
import com.example.aui2.dto.GetDwarvesResponse;
import com.example.aui2.functions.DwarfToResponseFunction;
import com.example.aui2.functions.DwarvesToResponseFunction;
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

    public DwarfDefaultController(DwarfService service, DwarfToResponseFunction dwarfToResponseFunction, DwarvesToResponseFunction dwarvesToResponseFunction) {
        this.service = service;
        this.dwarfToResponseFunction = dwarfToResponseFunction;
        this.dwarvesToResponseFunction = dwarvesToResponseFunction;
    }
@ResponseStatus(HttpStatus.OK)
    @ResponseBody

    @GetMapping("/drg/dwarves")
    public GetDwarvesResponse getDwarves() {
        if (service.findAll().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return dwarvesToResponseFunction.apply(service.findAll());
    }
//    public GetDwarvesResponse getDwarves() {
//        return service.findAll()
//                .map(dwarvesToResponseFunction)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//    }
//    @GetMapping("/drg/dwarves/{name}")
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public GetDwarfResponse getDwarf(String name) {
//        return service.find(name)
//                .map(dwarfToResponseFunction)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//    }
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/drg/dwarves/{uuid}")
    public GetDwarfResponse getDwarf(@PathVariable UUID uuid) {
        return service.find(uuid)
                .map(dwarfToResponseFunction)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
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
