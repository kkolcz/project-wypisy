import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ProductsComponent } from './components/products/products.component';
import { ProductsAddComponent } from './components/products/products-add/products-add.component';
import { ProductsDatabaseComponent } from './components/products/products-database/products-database.component';
import { ResourcesAddComponent } from './components/resources/resources-add/resources-add.component';
import { ResourcesDatabaseComponent } from './components/resources/resources-database/resources-database.component';
import { ResourcesComponent } from './components/resources/resources.component';
import { ProcessesComponent } from './components/processes/processes.component';
import { ProcessesAddComponent } from './components/processes/processes-add/processes-add.component';
import { ProcessesDatabaseComponent } from './components/processes/processes-database/processes-database.component';
import { PrescriptionComponent } from './components/prescription/prescription.component';
import { PrescriptionAddComponent } from './components/prescription/prescription-add/prescription-add.component';
import { PrescriptionDatabaseComponent } from './components/prescription/prescription-database/prescription-database.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  {
    path: 'products',
    component: ProductsComponent,
    children: [
      { path: 'add', component: ProductsAddComponent },
      { path: 'database', component: ProductsDatabaseComponent },
    ],
  },
  {
    path: 'resources',
    component: ResourcesComponent,
    children: [
      { path: 'add', component: ResourcesAddComponent },
      { path: 'database', component: ResourcesDatabaseComponent },
    ],
  },
  {
    path: 'prescription',
    component: PrescriptionComponent,
    children: [
      { path: 'add', component: PrescriptionAddComponent },
      { path: 'database', component: PrescriptionDatabaseComponent },
    ],
  },
  {
    path: 'processes',
    component: ProcessesComponent,
    children: [
      { path: 'add', component: ProcessesAddComponent },
      { path: 'database', component: ProcessesDatabaseComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
