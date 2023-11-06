package com.example.aui2;

import com.example.aui2.entity.Weapon;
import com.example.aui2.service.DwarfService;
import com.example.aui2.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.UUID;

@Component
public class ApplicationCommand implements CommandLineRunner {
    WeaponService weaponService;
    DwarfService dwarfService;

    @Autowired
    ApplicationCommand(DwarfService ds, WeaponService ws){
        weaponService = ws;
        dwarfService = ds;
    }
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        main_loop:
        while (true) {
            command = scanner.next();
            switch (command) {
                case "get_all_dwarves" -> {
                    dwarfService.dwarfRepo.findAll().forEach(System.out::println);
                }
                case "get_all_weapons" -> {
                    weaponService.weaponRepo.findAll().forEach(System.out::println);
                }
                case "get_weapons_by_dwarf" -> {
                    System.out.println("Dwarf:");
                    String dwarf = scanner.next();
                    weaponService.findByDwarf(dwarf).forEach(System.out::println);
                }
                case "delete_weapon" -> {
                    UUID uuid = UUID.fromString(scanner.next());
                    weaponService.delete(uuid);
                }
                case "add_weapon" -> {
                    System.out.println("Weapon name:");
                    String name = scanner.next();
                    System.out.println("Swarm damage:");
                    int dmg = Integer.parseInt(scanner.next());
                    System.out.println("Belongs to:");
                    String dwarf = scanner.next();

                    Weapon newWeapon = Weapon.builder()
                            .uuid(UUID.randomUUID())
                            .name(name)
                            .swarmDamage(dmg)
                            .dwarf(dwarfService.dwarfRepo.findByName(dwarf).get())
                            .build();

                    weaponService.create(newWeapon);
                }
                default -> {
                    System.out.println("get_all_dwarves");
                    System.out.println("get_all_weapons");
                    System.out.println("add_weapon");
                    System.out.println("delete_weapon");
                    System.out.println("help");
                    System.out.println("quit");
                }
                case "quit" -> {
                    break main_loop;
                }
            }
        }
    }
}
