import { Injectable } from '@angular/core';
import { Employee } from '../app/model/employee';
@Injectable({
  providedIn: 'root'
})
export class DataService {

  employees: Employee[];
  constructor() {
    this.employees=[];
   }

   getAllItems(){
     return this.employees;
   }

   add(employee:Employee){
     this.employees.push(employee);
   }
}