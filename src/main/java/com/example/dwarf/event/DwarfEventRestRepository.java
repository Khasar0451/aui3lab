package main.java.com.example.dwarf.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;
import main.java.com.example.dwarf.event.Config;
@Repository
public class DwarfEventRestRepository {
    private final RestTemplate restTemplate;

    @Autowired
    public DwarfEventRestRepository(RestTemplate template) {
        this.restTemplate = template;
    }

    public void delete(UUID id) {
        restTemplate.delete("/drg/dwarves/{id}", id);
    }

}

