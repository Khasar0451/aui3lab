import {Component, OnInit} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {NgIf} from "@angular/common";
import {DwarfForm} from "../../../dwarf/model/dwarf-form";
import {DwarfService} from "../../../dwarf/service/dwarf.service";
import {ActivatedRoute, Router} from "@angular/router";
import {WeaponForm} from "../../model/weaponForm";
import {WeaponService} from "../../service/weapon.service";
import {Weapon} from "../../model/weapon";

@Component({
  selector: 'app-weapon-edit',
  standalone: true,
    imports: [
        FormsModule,
        NgIf
    ],
  templateUrl: './weapon-edit.component.html',
  styleUrl: './weapon-edit.component.css'
})
export class WeaponEditComponent implements OnInit{
  idDwarf: string | undefined;
  idWeapon: string | undefined;
  weapon: WeaponForm|undefined;
  original: WeaponForm | undefined;

  constructor(
    private dwarfService: DwarfService,
    private weaponService: WeaponService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.idWeapon = params['idWeapon'];
      this.idDwarf = params['idDwarf'];
      this.weaponService.getWeapon(params['idWeapon'])
        .subscribe(weapon => {
          this.weapon = {
            name: weapon.name,
            swarmDamage: weapon.swarmDamage,
            uuid: params['idDwarf']
          };
          console.log(weapon.swarmDamage)
          console.log(weapon.name)
          this.original = {...this.weapon};
        });
    });
  }
  onSubmit(): void {
    this.weaponService.patchWeapon(this.idDwarf!, this.idWeapon!, this.weapon!)
      .subscribe(() => this.router.navigate(['/dwarves', this.idDwarf]));
  }
}
