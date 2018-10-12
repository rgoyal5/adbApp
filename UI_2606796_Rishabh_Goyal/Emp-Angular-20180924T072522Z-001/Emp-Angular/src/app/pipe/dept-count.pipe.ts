import { Pipe, PipeTransform } from '@angular/core';
import { Emplyoee } from '../model/emplyoee';

@Pipe({
  name: 'deptCount'
})
export class DeptCountPipe implements PipeTransform {

  transform(emplyoees: Emplyoee[], dept?:string): number {
    return emplyoees.filter((b)=>b.dept==dept).length;;
  }

}
