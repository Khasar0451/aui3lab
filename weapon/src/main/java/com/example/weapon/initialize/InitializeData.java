package com.example.weapon.initialize;

import com.example.dwarf.entity.Dwarf;
import com.example.weapon.entity.Weapon;

import com.example.dwarf.service.DwarfService;
import com.example.weapon.service.WeaponService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class InitializeData implements InitializingBean {
    WeaponService weaponService;
    DwarfService dwarfService;

    @Autowired
    InitializeData(WeaponService ws, DwarfService ds){
        weaponService = ws;dwarfService = ds;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        if(weaponService.findAll().isEmpty()){
            Dwarf engineer = Dwarf.builder()
                    .uuid(UUID.fromString("d620af71-586c-4969-a54a-ed35dbc8dc5d"))
                    .build();
            Dwarf scout = Dwarf.builder()
                    .uuid(UUID.fromString("2320af71-586c-4969-a54a-ed35dbc8dc5d"))
                    .build();
            Dwarf gunner = Dwarf.builder()
                    .uuid(UUID.fromString("d620af71-906c-4969-a54a-ed35dbc8dc5d"))
                    .build();
            Dwarf driller = Dwarf.builder()
                    .uuid(UUID.fromString("04510451-4242-4242-4242-045104510451"))
                    .build();

            dwarfService.create(engineer);
            dwarfService.create(scout);
            dwarfService.create(gunner);
            dwarfService.create(driller);


            Weapon autoShotgun = Weapon.builder()
                    .uuid(UUID.fromString("4c8684cb-25d4-406a-97f7-38b389e921fd"))
                    .name("AutoShotgun")
                    .swarmDamage(5)
                    .dwarf(engineer)
                    .build();
            Weapon voltaicSMG = Weapon.builder()
                    .uuid(UUID.randomUUID())
                    .name("VoltaicSMG")
                    .swarmDamage(8)
                    .dwarf(engineer)
                    .build();
            Weapon smartRifle = Weapon.builder()
                    .uuid(UUID.randomUUID())
                    .name("SmartRifle")
                    .swarmDamage(7)
                    .dwarf(engineer)
                    .build();

            weaponService.create(autoShotgun);
            weaponService.create(voltaicSMG);
            weaponService.create(smartRifle);

            Weapon assaultRifle = Weapon.builder()
                    .uuid(UUID.randomUUID())
                    .name("AssaultRifle")
                    .swarmDamage(6)
                    .dwarf(scout)
                    .build();
            Weapon m1Garand = Weapon.builder()
                    .uuid(UUID.randomUUID())
                    .name("M1000")
                    .swarmDamage(2)
                    .dwarf(scout)
                    .build();
            Weapon plasmaCarbine = Weapon.builder()
                    .uuid(UUID.randomUUID())
                    .name("PlasmaCarabine")
                    .swarmDamage(4)
                    .dwarf(scout)
                    .build();

            weaponService.create(assaultRifle);
            weaponService.create(m1Garand);
            weaponService.create(plasmaCarbine);

            Weapon minigun = Weapon.builder()
                    .uuid(UUID.randomUUID())
                    .name("Minigun")
                    .swarmDamage(8)
                    .dwarf(gunner)
                    .build();
            Weapon autocannon = Weapon.builder()
                    .uuid(UUID.randomUUID())
                    .name("Autocannon")
                    .swarmDamage(9)
                    .dwarf(gunner)
                    .build();
            Weapon guidedRocketLauncher = Weapon.builder()
                    .uuid(UUID.randomUUID())
                    .name("GuidedRocketLauncher")
                    .swarmDamage(8)
                    .dwarf(gunner)
                    .build();

            weaponService.create(minigun);
            weaponService.create(autocannon);
            weaponService.create(guidedRocketLauncher);


        }
    }
}
