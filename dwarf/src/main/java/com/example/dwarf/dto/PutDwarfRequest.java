package main.java.com.example.dwarf.dto;
import main.java.com.example.dwarf.*;

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
    //List<Weapon> weapons;
    int voicePitch;
}
