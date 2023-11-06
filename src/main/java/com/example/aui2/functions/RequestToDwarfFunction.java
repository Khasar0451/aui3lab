package com.example.aui2.functions;

import com.example.aui2.dto.PutDwarfRequest;
import com.example.aui2.entity.Dwarf;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;

@Component
public class RequestToDwarfFunction implements BiFunction<UUID, PutDwarfRequest, Dwarf> {

    @Override
    public Dwarf apply(UUID id, PutDwarfRequest request) {
        return Dwarf.builder()
                .uuid(id)
                .name(request.getName())
                .voicePitch(request.getVoicePitch())
                .weapons(request.getWeapons())
                .build();
    }
}