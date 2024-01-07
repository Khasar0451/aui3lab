package com.example.weapon.entity;

import jakarta.persistence.*;
import lombok.*;
import com.example.dwarf.entity.Dwarf;

import java.io.Serializable;
import java.util.UUID;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "weapons")
public class Weapon {
    @Id
    UUID uuid;

    @Column
    String name;

    @Column
    int swarmDamage;

    @ManyToOne
    @JoinColumn(name = "dwarf")
    Dwarf dwarf;

}
