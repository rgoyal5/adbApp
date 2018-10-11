import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule,Routes} from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { ContactFormComponent } from './contact-form/contact-form.component';
import { ContactTableComponent } from './contact-table/contact-table.component';

/*Routing Used for navigating*/
const routesMap : Routes=[
  {path:'ct',component:ContactTableComponent},
  {path:'cf',component:ContactFormComponent},
  ]
@NgModule({
  declarations: [
    AppComponent,
    ContactFormComponent,
    ContactTableComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routesMap),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
