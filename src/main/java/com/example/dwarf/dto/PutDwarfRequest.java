package main.java.com.example.dwarf.dto;

import lombok.*;

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
