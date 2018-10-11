import { Pipe, PipeTransform } from '@angular/core';
import { Employee } from '../model/employee';

@Pipe({
  name: 'fullName'
})
export class FullNamePipe implements PipeTransform {

  transform(employee: Employee): string {
    let result =employee.firstName+" "+employee.lastName;
    return result;
  }

}