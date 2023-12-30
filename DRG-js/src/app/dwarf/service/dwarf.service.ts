import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Dwarves } from "../model/dwarves";
import {Dwarf} from "../model/dwarf";
import {DwarfForm} from "../model/dwarf-form";
@Injectable({
  providedIn: 'root'
})
export class DwarfService {

  constructor(private http: HttpClient) {

  }
  getDwarves(): Observable<Dwarves> {
    return this.http.get<Dwarves>('/drg/dwarves');
  }
  getDwarf(): Observable<Dwarf> {
    return this.http.get<Dwarf>('/drg/dwarf');
  }
  deleteDwarves(uuid: string): Observable<any> {
    return this.http.delete('/drg/dwarves/' + uuid);
  }

  putDwarf(uuid: string, request: DwarfForm): Observable<any> {
    return this.http.put('/drg/dwarves/' + uuid, request);
  }

}
