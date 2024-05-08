import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { LoginComponent } from './components/login/login.component';
import { ProductsComponent } from './components/products/products.component';
import { ProductsAddComponent } from './components/products/products-add/products-add.component';
import { ProductsDatabaseComponent } from './components/products/products-database/products-database.component';
import { MaterialsAddComponent } from './components/materials/materials-add/materials-add.component';
import { MaterialsDatabaseComponent } from './components/materials/materials-database/materials-database.component';
import { MaterialsComponent } from './components/materials/materials.component';
import { ProcessesComponent } from './components/processes/processes.component';
import { ProcessesAddComponent } from './components/processes/processes-add/processes-add.component';
import { ProcessesDatabaseComponent } from './components/processes/processes-database/processes-database.component';
import { PrescriptionsComponent } from './components/prescriptions/prescriptions.component';
import { PrescriptionsAddComponent } from './components/prescriptions/prescriptions-add/prescriptions-add.component';
import { PrescriptionsDatabaseComponent } from './components/prescriptions/prescriptions-database/prescriptions-database.component';
import { authGuard } from './guards/auth.guard';
import { ToolsComponent } from './components/tools/tools.component';
import { ToolsDatabaseComponent } from './components/tools/tools-database/tools-database.component';
import { ToolsAddComponent } from './components/tools/tools-add/tools-add.component';
import { LocationComponent } from './components/location/location.component';
import { LocationDatabaseComponent } from './components/location/location-database/location-database.component';
import { LocationAddComponent } from './components/location/location-add/location-add.component';
import { ProcesscategoryComponent } from './components/processcategory/processcategory.component';
import { ProcesscategoryAddComponent } from './components/processcategory/processcategory-add/processcategory-add.component';
import { ProcesscategoryDatabaseComponent } from './components/processcategory/processcategory-database/processcategory-database.component';
import { MachineProgramComponent } from './components/machine-program/machine-program.component';
import { MachineProgramAddComponent } from './components/machine-program/machine-program-add/machine-program-add.component';
import { MachineProgramDatabaseComponent } from './components/machine-program/machine-program-database/machine-program-database.component';


const routes: Routes = [
  { path: '', component: LandingPageComponent },
  { path: 'login', component: LoginComponent },
  {
    path: 'products',
    component: ProductsComponent,
    canActivate: [authGuard],
    children: [
      { path: 'add', component: ProductsAddComponent },
      { path: 'database', component: ProductsDatabaseComponent },
    ],
  },
  {
    path: 'materials',
    canActivate: [authGuard],
    component: MaterialsComponent,
    children: [
      { path: 'add', component: MaterialsAddComponent },
      { path: 'database', component: MaterialsDatabaseComponent },
    ],
  },
  {
    path: 'prescription',
    canActivate: [authGuard],
    component: PrescriptionsComponent,
    children: [
      { path: 'add', component: PrescriptionsAddComponent },
      { path: 'database', component: PrescriptionsDatabaseComponent },
    ],
  },
  {
    path: 'processes',
    canActivate: [authGuard],
    component: ProcessesComponent,
    children: [
      { path: 'add', component: ProcessesAddComponent },
      { path: 'database', component: ProcessesDatabaseComponent },
    ],
  },
  {
    path: 'tools',
    canActivate: [authGuard],
    component: ToolsComponent,
    children: [

      { path: 'database', component: ToolsDatabaseComponent },
      { path: 'add', component: ToolsAddComponent},
    ],
  },
  {
    path: 'location',
    canActivate: [authGuard],
    component: LocationComponent,
    children: [
      { path: 'database', component: LocationDatabaseComponent },
      { path: 'add', component: LocationAddComponent },
      
    ],
  },
  {
    path: 'processcategory',
    canActivate: [authGuard],
    component: ProcesscategoryComponent,
    children: [
      { path: 'add', component: ProcesscategoryAddComponent},
      { path: 'database', component:ProcesscategoryDatabaseComponent },
      
    ],
  },
  {
    path: 'program',
    canActivate: [authGuard],
    component: MachineProgramComponent,
    children: [
      { path: 'add', component: MachineProgramAddComponent},
      { path: 'database', component:MachineProgramDatabaseComponent },
      
    ],
  }







];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
