package com.example.weapon.functions;

import com.example.weapon.dto.GetWeaponResponse;
import com.example.weapon.dto.GetWeaponsResponse;
import com.example.weapon.entity.Weapon;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;
@Component
public class WeaponToResponseFunction implements Function<Weapon, GetWeaponResponse> {
    @Override
    public GetWeaponResponse apply(Weapon weapon){
        return GetWeaponResponse.builder()
                .name(weapon.getName())
                .uuid(weapon.getUuid())
                .swarmDamage(weapon.getSwarmDamage())
                .build();
    }

}
