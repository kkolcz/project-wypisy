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
import { PrescriptionsComponent } from './components/prescriptions/prescriptions.component';
import { PrescriptionsAddComponent } from './components/prescriptions/prescriptions-add/prescriptions-add.component';
import { PrescriptionsDatabaseComponent } from './components/prescriptions/prescriptions-database/prescriptions-database.component';
import { authGuard } from './guards/auth.guard';

const routes: Routes = [
  { path: '', component: HomeComponent },
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
    path: 'resources',
    component: ResourcesComponent,
    children: [
      { path: 'add', component: ResourcesAddComponent },
      { path: 'database', component: ResourcesDatabaseComponent },
    ],
  },
  {
    path: 'prescription',
    component: PrescriptionsComponent,
    children: [
      { path: 'add', component: PrescriptionsAddComponent },
      { path: 'database', component: PrescriptionsDatabaseComponent },
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
