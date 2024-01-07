import {Component, OnInit} from '@angular/core';
import {WeaponService} from "../../service/weapon.service";
import {ActivatedRoute} from "@angular/router";
import {Weapon} from "../../model/weapon";
import {NgIf} from "@angular/common";
import {DwarfService} from "../../../dwarf/service/dwarf.service";
import {DwarfDetails} from "../../../dwarf/model/dwarf-details";

@Component({
  selector: 'app-weapon-view',
  standalone: true,
  imports: [
    NgIf
  ],
  templateUrl: './weapon-view.component.html',
  styleUrl: './weapon-view.component.css'
})
export class WeaponViewComponent implements OnInit{
  weapon: Weapon | undefined;
  dwarf: DwarfDetails | undefined;
  constructor(private service: WeaponService, private dwarfService: DwarfService, private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getWeapon(params['idWeapon'])
        .subscribe(weapon => this.weapon = weapon)
      this.dwarfService.getDwarf(params['idDwarf'])
        .subscribe(dwarf => this.dwarf = dwarf)
    });

  }

}
