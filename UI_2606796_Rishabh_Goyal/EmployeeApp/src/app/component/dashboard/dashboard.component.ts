import { Component, OnInit } from '@angular/core';
import { Contact } from '../../model/contact';
import { ContactService } from '../../service/contact.service';

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
  contacts: Contact[];

  constructor(private contactService:ContactService) {
    this.title = "Address Book 3.0";
    this.logoUrl = "/assets/images/adbLogo.png"; 
    this.ladyLogo = "/assets/images/lady.png";
    this.gentLogo = "/assets/images/gent.png";
  }

  ngOnInit() {
    this.contactService.getAllContacts().subscribe(
      (data) => this.contacts = data
    );
  }
}
