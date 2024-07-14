package com.example.aui2.functions;

import com.example.aui2.dto.GetWeaponResponse;
import com.example.aui2.entity.Weapon;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class WeaponToResponseFunction implements Function<Weapon, GetWeaponResponse> {
    @Override
    public GetWeaponResponse apply(Weapon weapon){
        return GetWeaponResponse.builder()
                .name(weapon.getName())
                .uuid(weapon.getUuid())
                .build();
    }
}
