package com.example.aui2.dto;

import com.example.aui2.entity.Dwarf;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode

public class PutWeaponRequest {
    //fields that can be set up byt the user
    String name;
    int swarmDamage;
    UUID UUIDdwarf;

}
