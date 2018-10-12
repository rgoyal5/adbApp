import { Component, OnInit } from '@angular/core';
import { EmplyoeeService } from '../../service/emplyoee.service';
import { Emplyoee } from '../../model/emplyoee';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  title: string;
  logoUrl: string;
  ladyLogo: string;
  gentLogo: string;
  emplyoees: Emplyoee[];

  constructor(private emplyoeeService: EmplyoeeService) {
    this.title = "Employee Portal 3.0";
    this.logoUrl = "/assets/images/emplogo.jpg";
    this.ladyLogo = "/assets/images/fem.jpg";
    this.gentLogo = "/assets/images/male.png";
  }
  ngOnInit() {
    this.emplyoeeService.getAllEmplyoees().subscribe(
      (data) => this.emplyoees = data);
  }
}
