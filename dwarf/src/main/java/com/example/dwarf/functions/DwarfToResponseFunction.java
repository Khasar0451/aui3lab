package com.example.aui2.functions;

import com.example.aui2.dto.GetDwarfResponse;
import com.example.aui2.entity.Dwarf;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class DwarfToResponseFunction implements Function<Dwarf, GetDwarfResponse> {
    @Override
    public GetDwarfResponse apply(Dwarf entity) {
        return GetDwarfResponse.builder()
                .uuid(entity.getUuid())
                .name(entity.getName())
                .build();
    }

}
