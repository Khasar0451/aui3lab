import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Weapons} from "../model/weapons";
import {Weapon} from "../model/weapon";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class WeaponService {

  constructor(private http: HttpClient) { }
  getWeapons(): Observable<Weapons> {
    return this.http.get<Weapons>('/drg/weapons');
  }
  getWeaponsByDwarf(uuid: string): Observable<Weapons>{
    return this.http.get<Weapons>('/drg/dwarves/' + uuid + '/weapons')
  }

  deleteWeapon(uuid:string): Observable<Weapon> {
    return this.http.delete<Weapon>('/drg/weapons/' + uuid);
  }

  //putWeapon()
}
