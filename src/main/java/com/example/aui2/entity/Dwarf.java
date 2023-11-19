package com.example.aui2.entity;

import jakarta.persistence.*;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@ToString
@Table(name = "dwarves")
public class Dwarf implements Comparable<Dwarf>, Serializable {
    @Id
    UUID uuid;

    @Column(unique = true)
    String name;

    @Column
    int voicePitch;

    @ToString.Exclude
    @OneToMany(mappedBy = "dwarf", fetch = FetchType.LAZY)
    List<Weapon> weapons = new ArrayList<>();

    public void addWeapon(Weapon w){
        if (weapons == null) {
           weapons = new ArrayList<>();
        }
        weapons.add(w);
    }

   @Override
    public int compareTo(Dwarf p) {
        return name.compareTo(p.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, voicePitch);
    }
}
