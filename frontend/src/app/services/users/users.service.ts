import { Injectable } from '@angular/core';

import {
  Http,
  Headers,
  RequestOptions,
  Response
} from '@angular/http';

import { Observable, ReplaySubject } from 'rxjs/Rx';
import 'rxjs/add/operator/map'

import { AuthService } from '../auth/auth.service';
import { User } from '../../models/user.model';
import { environment } from '../../../environments/environment';

@Injectable()
export class UsersService {

  constructor(
    private http: Http,
    private authService: AuthService
  ) {}

  getById(id: number): Observable<User> {
     return this.http.get(`${environment.host}api/users/${id}`)
      .map((res: Response) => {
        return res.json();
      }).catch(error => {
        throw Error(error.json() && error.json().message);
      });
  }

}
