package com.example.aui2.functions;

import com.example.aui2.dto.GetWeaponResponse;
import com.example.aui2.dto.GetWeaponsResponse;
import com.example.aui2.entity.Weapon;
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
