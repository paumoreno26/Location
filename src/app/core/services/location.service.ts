import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Parent } from '../models/parent';
import { Generic } from '../models/genericResponse';
import { Children } from '../models/children';
import { map, catchError, tap } from 'rxjs/operators';
import swal from 'sweetalert2';

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

  addCHildren(data: Children):Observable<any>{
    debugger
    const url =  `http://localhost:8080/location/child`;
    return this.http.post<Generic<any>>(url, data).pipe(
      catchError(e => {
        console.error(e.error.mensaje);
        swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  addParent(data: Parent):Observable<Generic<any>>{
    debugger
    const url =  `http://localhost:8080/location/parent`;
    return this.http.post<Generic<any>>(url, data).pipe(
      catchError(e => {
        console.error(e.error.mensaje);
        swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  deleteParent(id:number):Observable<Generic<any>>{
    const url = `http://localhost:8080/location/${id}`;
    return this.http.delete<Generic<any>>(url)
  }
}
