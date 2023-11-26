package main.java.com.example.dwarf.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode

public class GetDwarfResponse {
    String name;
    UUID uuid;
}
