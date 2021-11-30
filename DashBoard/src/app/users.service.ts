import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './userService';
import { environment } from 'src/environments/environment';



@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }


  
  //-----------------------------------Apprenants-----------------

  public getApprenant(): Observable<User[]>{
    return this.http.get<User[]>(`${this.apiServerUrl}/apprenant/all`);
  }

  public addApprenant(user: User): Observable<User>{
    return this.http.post<User>(`${this.apiServerUrl}/apprenant/add`, user);
  }

  public updateApprenant(id: number, user: any): Observable<User>{
    return this.http.put<User>(`${this.apiServerUrl}/apprenant/${id}`, user);

  }

  public deleteApprenant(id: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/apprenant/delete/${id}`);

  }


    //---------------------Formateur-----------------------

    public getPresenceListe(): Observable<User[]>{
      return this.http.get<User[]>(`${this.apiServerUrl}/presence/today`);
    }
  
}
