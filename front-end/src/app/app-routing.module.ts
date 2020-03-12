import { AuthGuardService } from './services/guards/auth-guard.service';
import { PersonComponent } from './components/person/person.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { LoginComponent } from './components/login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RouterPath } from './constants/router-path.const';


const routes: Routes = [
  {
    path: '', redirectTo: RouterPath.LOGIN, pathMatch: 'full'
  },
  {
    path: RouterPath.LOGIN, component: LoginComponent
  },
  {
    path: RouterPath.DASHBOARD, component: DashboardComponent, canActivate:[AuthGuardService]
  },
  {
    path: RouterPath.PERSON, component: PersonComponent, canActivate:[AuthGuardService]
  },
  {
    path: '**', component: PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
