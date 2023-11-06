package com.example.aui2.repository;

import com.example.aui2.entity.Dwarf;
import com.example.aui2.entity.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DwarfRepo extends JpaRepository<Dwarf, UUID> {
    Optional<Dwarf> findByUuid(UUID uuid);

    Optional<Dwarf> findByName(String name);
}
