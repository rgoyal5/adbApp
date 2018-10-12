import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, Response } from '@angular/http';
import { Emplyoee } from '../model/emplyoee';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class EmplyoeeService {
  baseUrl: string;
  constructor(private http: Http) {
    this.baseUrl = "http://localhost:7336/Employees";
  }
  getBaseUrlbyId(id: number): string {
    return this.baseUrl + "/" + id;
  }
  getSearchUrl(field: string, value: string): string {
    return this.baseUrl + "/" + field + "/" + value;
  }
  getJsonContentTypeHeader(): RequestOptions {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return new RequestOptions({ headers: headers });
  }
  getAllEmplyoees(): Observable<Emplyoee[]> {
    return this.http.get(this.baseUrl).pipe(
      map(data => data.json())
    );
  }
  getEmplyoeeById(id: number): Observable<Emplyoee> {
    return this.http.get(this.getBaseUrlbyId(id)).pipe(
      map(data => data.json())
    );
  }
  searchEmplyoees(field: string, value: string): Observable<Emplyoee[]> {
    return this.http.get(this.getSearchUrl(field, value)).pipe(map(data => data.json()));
  }
  deleteEmplyoeeById(id: number): Observable<Response> {
    return this.http.delete(this.getBaseUrlbyId(id));
  }
  addEmplyoee(emplyoee: Emplyoee): Observable<Emplyoee> {
    return this.http.post(this.baseUrl, JSON.stringify(emplyoee), this.getJsonContentTypeHeader()).pipe(
      map(data => data.json())
    );
  }
  updateEmplyoee(emplyoee: Emplyoee): Observable<Emplyoee> {
    return this.http.put(this.baseUrl, JSON.stringify(emplyoee), this.getJsonContentTypeHeader()).pipe(
      map(data => data.json())
    );
  }


}
