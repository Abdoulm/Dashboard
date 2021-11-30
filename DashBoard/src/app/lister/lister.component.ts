import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { UsersService } from '../users.service';
import { User } from '../userService';

@Component({
  selector: 'app-lister',
  templateUrl: './lister.component.html',
  styleUrls: ['./lister.component.css']
})
export class ListerComponent implements OnInit {

  public user: User[];
  public editApprenant: User;
  public deleteApprenant: User;

  constructor(private userservice: UsersService) { }

  ngOnInit(): void {
    this.getPresenceListe();
  }


  public getPresenceListe(): void {
    this.userservice.getPresenceListe().subscribe(
      (response:  User[]) => {
        console.log(response)
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
        this.getPresenceListe();
      },
      (error: HttpErrorResponse) =>{
        alert(error.message)
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
      this.getPresenceListe();
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
