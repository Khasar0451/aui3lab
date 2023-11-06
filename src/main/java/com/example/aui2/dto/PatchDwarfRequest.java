package com.example.aui2.dto;

import com.example.aui2.entity.Dwarf;
import com.example.aui2.entity.Weapon;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class PatchDwarfRequest {
    private String name;

    private int voicePitch;

    private List<Weapon> weapons;

}
