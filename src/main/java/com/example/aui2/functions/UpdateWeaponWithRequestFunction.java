package com.example.aui2.functions;

import com.example.aui2.dto.PatchWeaponRequest;
import com.example.aui2.entity.Weapon;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
@Component
public class UpdateWeaponWithRequestFunction implements BiFunction<Weapon, PatchWeaponRequest, Weapon> {    //BiFunction - two types as input, one as output

    @Override
    public Weapon apply(Weapon entity, PatchWeaponRequest request) {
        return Weapon.builder()
                .uuid(entity.getUuid())         //from entity - can't be updated
                .name(request.getName())        //from request - can be updated
                .dwarf(entity.getDwarf())
                .swarmDamage(request.getSwarmDamage())
                .build();
    }

}
