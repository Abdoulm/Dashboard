import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, NgForm } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { UsersService } from '../users.service';
import { User } from '../userService';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  public user: User[];
  public editApprenant: User;
  public deleteApprenant: User;
  public id_apprenant: any;
  public putBody:any;
  options: FormGroup
 
   constructor(private userservice: UsersService, private activatedRoute: ActivatedRoute){
     

   }
 
   ngOnInit() {
     this.getApprenants();
   }


   getApprenantId(appId:any){

   }
   
  public getApprenants(): void {
    this.userservice.getApprenant().subscribe(
      (response:  User[]) => {
       // console.log(response)
        this.user = response;
      },
      (
        error: HttpErrorResponse) => {
          alert(error.message);
        }
    );
    
}

  public onAddApprenant(addForm: NgForm): void {
    document.getElementById('add-Apprenant-form')?.click();
    this.userservice.addApprenant(addForm.value).subscribe(
      (response: User) =>{
        console.log(response);
        this.getApprenants();
      },
      (error: HttpErrorResponse) =>{
        alert(error.message)
      }
    );
    
  }
  
  public onUpdateApprenant(addForm: NgForm): void {

    this.putBody = {

    "nom": addForm.value.name,
    "prenom": addForm.value.jobTitle,
    "tel": addForm.value.phone,
    "email": addForm.value.email,
    }

    console.log(this.putBody);

    this.userservice.updateApprenant(this.editApprenant.idApprenant, this.putBody).subscribe(
      (response: User) => {
        console.log(response);
        this.getApprenants();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteApprenant(id_apprenant: any): void {
    this.userservice.deleteApprenant(id_apprenant).subscribe(
      (response: void) => {
        console.log(response);
        this.getApprenants();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  
  
public searchApprenants(key: string): void {
  console.log(key);
  const results: User[] = [];
  for (const users of this.user) {
    if (users.nom.toLowerCase().indexOf(key.toLowerCase()) !== -1
    || users.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
    || users.tel.toLowerCase().indexOf(key.toLowerCase()) !== -1
    || users.prenom.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
      results.push(users);
    }
  }
  this.user = results;
  if (results.length === 0 || !key) {
    this.getApprenants();
  }
}


  public onOpenModal(user: any, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addApprenantModal');
    }
    if (mode === 'edit') {
      this.editApprenant = user;
      // console.log(this.editApprenant.idApprenant);
      // console.log(this.editApprenant);
      button.setAttribute('data-target', '#updateApprenantModal');
    }
    if (mode === 'delete') {
      this.deleteApprenant = user;
      button.setAttribute('data-target', '#deleteApprenantModal');
    }
    container!.appendChild(button);
    button.click();
  }
  

}
