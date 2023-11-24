package com.example.aui2.dto;

import com.example.aui2.entity.Dwarf;
import lombok.*;

import java.util.Objects;
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
