import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { Apprenant } from './apprenant';

import { ApprenantService } from './apprenant.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  public apprenants: Apprenant[];


  constructor(private apprenantService: ApprenantService){}

  

  public getApprenants(): void {
    this.apprenantService.getApprenant().subscribe(
      (response:  Apprenant[]) => {
        this.apprenants = response;
      },
      (
        error: HttpErrorResponse) => {
          alert(error.message);
        }
    );
    
  }
}
