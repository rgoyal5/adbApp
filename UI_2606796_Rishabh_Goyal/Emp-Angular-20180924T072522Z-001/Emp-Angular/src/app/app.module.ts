import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { RouterModule,Routes } from '@angular/router';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { EmplyoeeListComponent } from './component/emplyoee-list/emplyoee-list.component';
import { EmplyoeeDetailsComponent } from './component/emplyoee-details/emplyoee-details.component';
import { EmplyoeeFormComponent } from './component/emplyoee-form/emplyoee-form.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { GenderCountPipe } from './pipe/gender-count.pipe';
import { DeptCountPipe } from './pipe/dept-count.pipe';
import { DaleteEmployeeComponent } from './component/dalete-employee/dalete-employee.component';

const paths:Routes=[
  {path:'',component:DashboardComponent},
  {path:'listEmplyoees',component:EmplyoeeListComponent},
  {path:'addEmplyoee',component:EmplyoeeFormComponent},
  {path:'editEmplyoee/:id',component:EmplyoeeFormComponent},
  {path:'viewEmplyoee/:id',component:EmplyoeeDetailsComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    EmplyoeeListComponent,
    EmplyoeeDetailsComponent,
    EmplyoeeFormComponent,
    DashboardComponent,
    GenderCountPipe,
    DeptCountPipe,
    DaleteEmployeeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(paths)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
