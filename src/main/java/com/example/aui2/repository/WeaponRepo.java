package com.example.aui2.repository;

import com.example.aui2.entity.Dwarf;
import com.example.aui2.entity.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface WeaponRepo extends JpaRepository<Weapon, UUID> {
    List<Weapon> findByDwarf(Dwarf dwarf);
    Optional<Weapon> findByName(String name);
    Optional<Weapon> findByUuid(UUID uuid);
}
