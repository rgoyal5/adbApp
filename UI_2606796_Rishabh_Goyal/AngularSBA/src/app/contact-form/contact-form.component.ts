import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router'
import { Contact } from '../model/Contact';
import { ContactServiceService } from '../contact-service.service';

@Component({
  selector: 'app-contact-form',
  templateUrl: './contact-form.component.html',
  styleUrls: ['./contact-form.component.css']
})
export class ContactFormComponent implements OnInit {
  contact:Contact;
  erros:string[];
  isError:boolean;
  constructor(
    private inv:ContactServiceService,
    private router:Router,
    private activatedRoute : ActivatedRoute,
  ) { 
    this.erros=[];
    this.isError=false;
  }

  ngOnInit() {
  this.contact=new Contact();
  }
/*Calling Contact Service and saving the data in contacts array*/

  save(){
   
    this.inv.add(this.contact);
    
   this.router.navigateByUrl("/ct");
  }

 
  cancel(){
    this.router.navigateByUrl("/ct");
  }


}

