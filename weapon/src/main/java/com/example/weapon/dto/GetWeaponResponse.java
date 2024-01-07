package com.example.weapon.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode

public class GetWeaponResponse {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode

    public static class Weapon{
        UUID uuid;
        String name;
        int swarmDamage;
    }
    UUID uuid;
    String name;
    int swarmDamage;
}