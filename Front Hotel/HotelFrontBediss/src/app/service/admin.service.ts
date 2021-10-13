import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";

export const httpOptions = {
  headers : new HttpHeaders({
    'Authorization' : environment.apiBasicAuth // administrateur   - 1234
  })
};

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http : HttpClient) { }

  authenticate(admin : any)
  {
    return this.http.post<any>(environment.apiUrl + "login", admin, httpOptions)
  }
}