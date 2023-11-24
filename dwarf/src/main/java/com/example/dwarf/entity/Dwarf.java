package main.java.com.example.dwarf.entity;

import jakarta.persistence.*;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "dwarves")
public class Dwarf implements Serializable {
    @Id
    UUID uuid;

    @Column(unique = true)
    String name;

    @Column
    int voicePitch;
}
