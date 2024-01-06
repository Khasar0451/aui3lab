package com.example.weapon.functions;

import com.example.weapon.dto.PutWeaponRequest;
import com.example.dwarf.entity.Dwarf;
import com.example.weapon.entity.Weapon;
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
                        .uuid(UUID.fromString(request.getUuid()))
                        .build())
                .swarmDamage(request.getSwarmDamage())
                .build();
    }
}


