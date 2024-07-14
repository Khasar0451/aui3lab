import {Component, OnInit} from '@angular/core';
import {DwarfService} from "../../service/dwarf.service";
import {Dwarves} from "../../model/dwarves";
import {Dwarf} from "../../model/dwarf";
import {RouterLink} from "@angular/router";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-dwarf-list',
  templateUrl: './dwarf-list.component.html',
  styleUrl: './dwarf-list.component.css'
})
export class DwarfListComponent implements OnInit{
  constructor(private service: DwarfService) {
  }

  dwarves: Dwarves | undefined;

  ngOnInit() {
    this.service.getDwarves().subscribe(dwarves => this.dwarves = dwarves)
  }

  onDelete(dwarf: Dwarf): void {
    this.service.deleteDwarf(dwarf.id).subscribe(() => this.ngOnInit());
  }
}
