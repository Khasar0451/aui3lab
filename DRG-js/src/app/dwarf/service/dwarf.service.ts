import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Dwarves } from "../model/dwarves";
/**
 * dwarves management service. Calls REST endpoints.
 */
@Injectable({
  providedIn: 'root'
})
export class DwarfService {

  /**
   * @param http HTTP client
   */
  constructor(private http: HttpClient) {

  }

  /**
   * Fetches all dwarves.
   *
   * @return list of dwarves
   */
  getDwarves(): Observable<Dwarves> {
    return this.http.get<Dwarves>('/drg/dwarves');
  }

}
