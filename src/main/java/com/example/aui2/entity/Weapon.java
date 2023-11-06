package com.example.aui2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "weapons")
public class Weapon implements Comparable<Weapon>, Serializable {
    @Id
    UUID uuid;
    String name;
    int swarmDamage;
    @ManyToOne
    @JoinColumn(name = "dwarf")
    Dwarf dwarf;

    @Override
    public int hashCode() {
        return Objects.hash(name, swarmDamage, dwarf);
    }

    @Override
    public int compareTo(Weapon o){
        int ret = name.compareTo(o.name);
        if (ret == 0) {
            ret = swarmDamage - o.swarmDamage;
            if (ret == 0) {
                ret = dwarf.compareTo(o.dwarf);
            }
        }
        return ret;
    }

}
