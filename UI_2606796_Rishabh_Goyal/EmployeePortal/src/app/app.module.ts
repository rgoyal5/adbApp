import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule,Routes} from '@angular/router';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { EmployeeFormComponent } from './component/employee-form/employee-form.component';
import { EmployeeListComponent } from './component/employee-list/employee-list.component';
import { EmployeeDetailsComponent } from './component/employee-details/employee-details.component';
import { EmployeeDeleteComponent } from './component/employee-delete/employee-delete.component';
import { AngularFontAwesomeModule } from 'angular-font-awesome';
import { FullNamePipe } from './pipe/full-name.pipe';
import { AdjustLengthPipe } from './pipe/adjust-length.pipe';
import { GenderCountPipe } from './pipe/gender-count.pipe';
import { BornTodayPipe } from './pipe/born-today.pipe';

const paths:Routes=[
  {path:'',component:DashboardComponent},
  {path:'listEmployees',component:EmployeeListComponent},
  {path:'addEmployee',component:EmployeeFormComponent},
  {path:'editEmployee/:id',component:EmployeeFormComponent},
  {path:'viewEmployee/:id',component:EmployeeDetailsComponent},
  {path:'delEmployee/:id',component:EmployeeDeleteComponent}
  
]
@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    EmployeeFormComponent,
    EmployeeListComponent,
    EmployeeDetailsComponent,
    EmployeeDeleteComponent,
    FullNamePipe,
    AdjustLengthPipe,
    GenderCountPipe,
    BornTodayPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AngularFontAwesomeModule,
    RouterModule.forRoot(paths)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
