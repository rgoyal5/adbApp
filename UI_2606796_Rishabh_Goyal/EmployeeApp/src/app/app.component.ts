import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title : string;
  logoUrl: string;

  constructor(){
    this.title="Address Book 3.0";
    this.logoUrl="/assets/images/adbLogo.png";
  }
}
