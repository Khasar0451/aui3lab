package com.example.weapon.functions;

import com.example.weapon.dto.PatchWeaponRequest;
import com.example.weapon.entity.Weapon;
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
