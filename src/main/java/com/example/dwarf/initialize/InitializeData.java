package main.java.com.example.dwarf.initialize;

import main.java.com.example.dwarf.service.DwarfService;
import main.java.com.example.dwarf.entity.Dwarf;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class InitializeData implements InitializingBean {
    DwarfService dwarfService;

    @Autowired
    InitializeData(DwarfService ds){
        dwarfService = ds;
    }

@Override
    public void afterPropertiesSet() throws Exception {
    Dwarf engineer = Dwarf.builder()
            .uuid(UUID.fromString("d620af71-586c-4969-a54a-ed35dbc8dc5d"))
            .name("Engineer")
            .voicePitch(105)
            .build();
    Dwarf scout = Dwarf.builder()
            .uuid(UUID.fromString("2320af71-586c-4969-a54a-ed35dbc8dc5d"))
            .name("Scout")
            .voicePitch(115)
            .build();
    Dwarf gunner = Dwarf.builder()
            .uuid(UUID.fromString("d620af71-906c-4969-a54a-ed35dbc8dc5d"))
            .name("Gunner")
            .voicePitch(90)
            .build();
    Dwarf driller = Dwarf.builder()
            .uuid(UUID.fromString("04510451-4242-4242-4242-045104510451"))
            .name("Driller")
            .voicePitch(85)
            .build();

    dwarfService.create(engineer);
    dwarfService.create(scout);
    dwarfService.create(gunner);
    dwarfService.create(driller);
    }
}
