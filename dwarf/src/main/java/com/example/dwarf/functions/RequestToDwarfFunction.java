package main.java.com.example.dwarf.functions;

import main.java.com.example.dwarf.dto.PutDwarfRequest;
import main.java.com.example.dwarf.entity.Dwarf;
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
         //       .weapons(request.getWeapons())
                .build();
    }
}