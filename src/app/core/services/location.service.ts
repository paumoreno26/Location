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


  loadParent(): Observable<Generic<Parent[]>>{
    const url =  `http://localhost:8080/location/parent`

    return this.http.get<Generic<Parent[]>>(url);
  }

  loadChildren(id: number): Observable<Generic<Children[]>>{
    const url =  `http://localhost:8080/location/child/${id}`

    return this.http.get<Generic<Children[]>>(url);
  }

  addCHildren(data: Children):Observable<Generic<any>>{
    debugger
    const url =  `http://localhost:8080/location/child`;
    return this.http.post<Generic<any>>(url, data)
  }

  addParent(data: Parent):Observable<Generic<any>>{
    debugger
    const url =  `http://localhost:8080/location/parent`;
    return this.http.post<Generic<any>>(url, data)
  }

  deleteParent(id:number):Observable<Generic<any>>{
    const url = `http://localhost:8080/location/${id}`;
    return this.http.delete<Generic<any>>(url)
  }
}
