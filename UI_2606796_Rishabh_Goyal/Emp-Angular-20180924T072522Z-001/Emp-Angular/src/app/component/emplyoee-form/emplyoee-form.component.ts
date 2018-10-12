import { Component, OnInit } from '@angular/core';
import { Emplyoee } from '../../model/emplyoee';
import { ActivatedRoute , Router } from '@angular/router';
import { EmplyoeeService } from '../../service/emplyoee.service';

@Component({
  selector: 'app-emplyoee-form',
  templateUrl: './emplyoee-form.component.html',
  styleUrls: ['./emplyoee-form.component.css']
})
export class EmplyoeeFormComponent implements OnInit {
  emplyoee: Emplyoee;
  isEditing: boolean;
  constructor(
    private activatedRoute: ActivatedRoute,
    private emplyoeeService: EmplyoeeService,
    private router:Router
  ) { }

  ngOnInit() {
    this.emplyoee = new Emplyoee();
    this.isEditing = false;

    this.activatedRoute.params.subscribe(
      (params) => {
        let emplyoeeId = params['id'];
        if (emplyoeeId) {
          this.emplyoeeService.getEmplyoeeById(emplyoeeId).subscribe(
            (data) => {
              this.emplyoee = data;
              this.isEditing = true;
            }
          );
        }
      }
    );
  }
  save() {
    if (this.isEditing) {
      this.emplyoeeService.updateEmplyoee(this.emplyoee).subscribe(
        (data) => {
          this.router.navigateByUrl("/");
        }
      );
    }

  }
}
