package main.java.com.example.dwarf.functions;

import main.java.com.example.dwarf.dto.PatchDwarfRequest;
import main.java.com.example.dwarf.entity.Dwarf;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
@Component

public class UpdateDwarfWithRequestFunction implements BiFunction<Dwarf, PatchDwarfRequest, Dwarf> {    //BiFunction - two types as input, one as output

    @Override
    public Dwarf apply(Dwarf entity, PatchDwarfRequest request) {
        return Dwarf.builder()
                .uuid(entity.getUuid())         //from entity - can't be updated
                .name(request.getName())        //from request - can be updated
              //  .weapons(request.getWeapons())
                .voicePitch(request.getVoicePitch())
                .build();
    }

}
