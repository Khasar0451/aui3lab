package main.java.com.example.dwarf.entity;

import jakarta.persistence.*;

import lombok.*;

import java.io.Serializable;
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
public class  Dwarf implements Serializable {
    @Id
    private UUID uuid;

    @Column(unique = true)
    private String name;

    @Column
    private int voicePitch;

}
