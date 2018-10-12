import { Component, OnInit } from '@angular/core';
import { Emplyoee } from '../../model/emplyoee';
import { EmplyoeeService } from '../../service/emplyoee.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-dalete-employee',
  templateUrl: './dalete-employee.component.html',
  styleUrls: ['./dalete-employee.component.css']
})
export class DaleteEmployeeComponent implements OnInit {

  employee: Emplyoee;
  ladyLogo: string;
  gentLogo: string;
  constructor(private employeeService:EmplyoeeService,
    private activatedRoute: ActivatedRoute,
    private router : Router
  ) {
  this.ladyLogo = "/assets/images/fem.jpg";
    this.gentLogo = "/assets/images/male.png";
  }

  ngOnInit() {
    this.activatedRoute.params.subscribe(
      (params) => {
        let Id = params['id'];
        if (Id) {
          this.employeeService.getEmplyoeeById(Id).subscribe(
            (data) => this.employee = data
          );
        }
      }
    );
  }

  doDelete(isConfirmed:boolean){
    if(isConfirmed){
      this.employeeService.deleteEmplyoeeById(this.employee.empId).subscribe(
        (resp) =>{
          if(resp.ok){
            this.router.navigateByUrl("/?opt=d&id="+this.employee.empId);
          }
        }
      );
    }else{
      this.router.navigateByUrl("/");
    }
  }
}


