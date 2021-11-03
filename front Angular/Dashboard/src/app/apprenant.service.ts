import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Apprenant} from './apprenant'
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class ApprenantService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }


  public getApprenant(): Observable<Apprenant[]>{
    return this.http.get<Apprenant[]>(`${this.apiServerUrl}/apprenant/all`);
  }

  public addApprenant(apprenant: Apprenant): Observable<Apprenant>{
    return this.http.post<Apprenant>(`${this.apiServerUrl}/apprenant/add`, apprenant);
  }

  public updateApprenant(apprenant: Apprenant): Observable<Apprenant>{
    return this.http.put<Apprenant>(`${this.apiServerUrl}/apprenant/update`, apprenant);

  }

  public deleteApprenant(apprenantId: number): Observable<void>{
    return this.http.delete<void>(`${this.apiServerUrl}/apprenant/delete${apprenantId}`);

  }
}
