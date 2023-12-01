package main.java.com.example.dwarf.repository;

import main.java.com.example.dwarf.entity.Dwarf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DwarfRepo extends JpaRepository<Dwarf, UUID> {
//    Optional<Dwarf> findByUuid(UUID uuid);
//
//    Optional<Dwarf> findByName(String name);
}
