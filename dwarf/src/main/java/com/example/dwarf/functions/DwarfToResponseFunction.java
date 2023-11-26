package main.java.com.example.dwarf.functions;

import main.java.com.example.dwarf.dto.GetDwarfResponse;
import main.java.com.example.dwarf.entity.Dwarf;
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
