import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Parent } from '../models/parent';
import { Generic } from '../models/genericResponse';
import { Children } from '../models/children';

@Injectable({
  providedIn: 'root'
})
export class LocationService {

  constructor(private http: HttpClient) { }


  loadParent(): Observable<Generic>{
    const url =  `http://localhost:8080/location/parent`

    return this.http.get<Generic>(url);
  }

  addCHildren(data: Children):Observable<any>{
    debugger
    const url =  `http://localhost:8080/location/child`;
    return this.http.post<any>(url, data)
  }
}
