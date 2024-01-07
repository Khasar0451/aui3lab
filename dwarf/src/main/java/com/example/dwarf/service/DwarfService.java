package main.java.com.example.dwarf.service;

import main.java.com.example.dwarf.entity.Dwarf;
// import com.example.aui2.entity.Weapon;
import main.java.com.example.dwarf.event.DwarfEventRestRepository;
import main.java.com.example.dwarf.repository.DwarfRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DwarfService {
    public DwarfRepo dwarfRepo;
    DwarfEventRestRepository eventRestRepository;

    @Autowired
    DwarfService(DwarfRepo dwarfRepo, DwarfEventRestRepository eventRestRepository){
        this.dwarfRepo = dwarfRepo; this.eventRestRepository = eventRestRepository;
    }

    public void create(Dwarf dwarf){
        dwarfRepo.save(dwarf);
        eventRestRepository.put(dwarf, dwarf.getUuid());
    }
    public void update(Dwarf dwarf){
        dwarfRepo.save(dwarf);
    }
    public Optional<Dwarf> find(UUID uuid){
        return dwarfRepo.findById(uuid);
    }
    public List<Dwarf> findAll(){
        return dwarfRepo.findAll();
    }
    public void delete(UUID uuid){
        dwarfRepo.findById(uuid).ifPresent(dwarfRepo::delete);
        eventRestRepository.delete(uuid);
    }

}
