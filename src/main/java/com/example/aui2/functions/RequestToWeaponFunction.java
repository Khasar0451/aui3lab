package com.example.aui2.functions;

import com.example.aui2.dto.GetWeaponsResponse;
import com.example.aui2.dto.PutWeaponRequest;
import com.example.aui2.entity.Dwarf;
import com.example.aui2.entity.Weapon;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToWeaponFunction implements BiFunction<UUID, PutWeaponRequest, Weapon> {    //build weapon from request

    @Override
    public Weapon apply(UUID id, PutWeaponRequest request) {
        return Weapon.builder()
                .uuid(id)
                .name(request.getName())
                .dwarf(Dwarf.builder()
                        .uuid(request.getUUIDdwarf())
                        .build())
                //.dwarf(request.getUUIDdwarf())
                .swarmDamage(request.getSwarmDamage())
                .build();
    }
}


