import { Pipe, PipeTransform } from '@angular/core';
import { Emplyoee } from '../model/emplyoee';

@Pipe({
  name: 'genderCount'
})
export class GenderCountPipe implements PipeTransform {

  transform(emplyoees: Emplyoee[], gender: string): number {
    return emplyoees.filter(c=>c.gender==gender).length;
  }

}
