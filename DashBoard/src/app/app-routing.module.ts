import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { ListerComponent } from './lister/lister.component';

const routes: Routes = [
  {path:'', component: IndexComponent},
  {path:'Lister', component: ListerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
