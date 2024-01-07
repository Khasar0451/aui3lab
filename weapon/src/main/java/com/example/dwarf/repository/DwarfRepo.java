package com.example.dwarf.repository;

import com.example.dwarf.entity.Dwarf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DwarfRepo extends JpaRepository<Dwarf, UUID> {

}
