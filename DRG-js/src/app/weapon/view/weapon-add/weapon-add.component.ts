import {Component, OnInit} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {NgIf} from "@angular/common";
import {v4 as uuidv4} from "uuid";
import {WeaponForm} from "../../model/weaponForm";
import {ActivatedRoute, Router} from "@angular/router";
import {WeaponService} from "../../service/weapon.service";
import {DwarfService} from "../../../dwarf/service/dwarf.service";

@Component({
  selector: 'app-weapon-add',
  standalone: true,
  imports: [
    FormsModule,
    NgIf
  ],
  templateUrl: './weapon-add.component.html',
  styleUrl: './weapon-add.component.css'
})
export class WeaponAddComponent implements OnInit{
  weapon : WeaponForm | undefined
  dwarfUuid: string | undefined
  dwarfName: string | undefined
  constructor(private router: Router, private route: ActivatedRoute, private weaponService: WeaponService, private dwarfService: DwarfService) {
  }
  ngOnInit():void{
    this.route.params.subscribe(params =>
      {this.dwarfUuid = params['uuid']
      console.log(this.dwarfUuid)}
    )
    this.weapon = {
      name:"",
      swarmDamage: 0,
      dwarf:this.dwarfUuid!
    }
    console.log(this.dwarfUuid)
    this.dwarfService.getDwarf(this.dwarfUuid!).subscribe(dwarf => this.dwarfName = dwarf.name)
  }
  onSubmit(): void {
    this.weaponService.putWeapon(uuidv4() ,this.weapon!)
      .subscribe(() => this.router.navigate(['/dwarves']));
  }
}
