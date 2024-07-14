package com.example.aui2.dto;

import com.example.aui2.entity.Dwarf;
import com.example.aui2.entity.Weapon;
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

public class PutDwarfRequest {
    //fields that can be set up byt the user
    String name;
    List<Weapon> weapons;
    int voicePitch;
}
