package com.example.dwarf.entity;

import jakarta.persistence.*;
import lombok.*;
import com.example.weapon.entity.Weapon;

import java.io.Serializable;
import java.util.*;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity

@Table(name = "dwarves")
public class Dwarf {
    @Id
    private UUID uuid;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "dwarf", cascade = CascadeType.REMOVE)
    private List<Weapon> weapons;
}
