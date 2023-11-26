package com.example.weapon.functions;

import com.example.weapon.dto.GetWeaponResponse;
import com.example.weapon.dto.GetWeaponsResponse;
import com.example.weapon.entity.Weapon;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

// List -> GetWeaponResponse
@Component
public class WeaponsToResponseFunction implements Function<List<Weapon>, GetWeaponsResponse> {
    @Override
    public GetWeaponsResponse apply(List<Weapon> w) {
        return GetWeaponsResponse.builder()
                .weapons(w.stream()
                        .map(weaponLambda -> GetWeaponsResponse.Weapon.builder()
                                .uuid(weaponLambda.getUuid())
                                .name(weaponLambda.getName())
                                .build())
                        .toList())
                .build();

    }
}
