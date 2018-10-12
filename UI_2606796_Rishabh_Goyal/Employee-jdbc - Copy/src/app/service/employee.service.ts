import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
import {Observable} from 'rxjs';
import { map } from 'rxjs/operators';
import { Employee} from '../model/employee';
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  baseUrl:string;
  constructor(private http:Http) {
    this.baseUrl="http://localhost:9190/employees";

   }

   getIdIncludeBaseUrl(eid):string{
     return this.baseUrl+"/"+eid;
   }

   getAll() : Observable<Employee[]>{
     return this.http.get(this.baseUrl).pipe(
      map((data) => data.json())
    );
   }
   getEmployee(eid) : Observable<Employee>{
    return this.http.get(this.getIdIncludeBaseUrl(eid)).pipe(
     map((data) => data.json())
   );
  }

  delete(eid) : Observable<Response>{
    return this.http.delete(this.getIdIncludeBaseUrl(eid));
  }

  getJsonContentTypeHeader() : RequestOptions{
        const headers = new Headers();
            headers.append('Content-Type', 'application/json');
                return new RequestOptions ({ headers: headers });   
               }



  addBook(employee:Employee):Observable<Employee>{
    let url=this.baseUrl;
    let content = JSON.stringify(employee);
    let headers=this.getJsonContentTypeHeader();

    return this.http.post(url,content,headers).pipe(
      map(data=>data.json())
    );
  }
  updateBook(employee:Employee):Observable<Employee>{
    let url=this.baseUrl;
    let content = JSON.stringify(employee);
    let headers=this.getJsonContentTypeHeader();

    return this.http.put(url,content,headers).pipe(
      map(data=>data.json())
    );
  }
}
