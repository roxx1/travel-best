import { Injectable } from '@angular/core';

import {
  Http,
  Headers,
  RequestOptions,
  Response
} from '@angular/http';

import { Observable, ReplaySubject } from 'rxjs/Rx';
import 'rxjs/add/operator/map'

import { Trip } from '../../models/trip.model';
import { Route } from '../../models/route.model';

import { environment } from '../../../environments/environment';

@Injectable()
export class TripsService {

  constructor(private http: Http) {}

  getTrips(): Observable<Array<Trip>> {
    return this.http.get(environment.host + "api/trips")
        .map((res: Response) => {
          return res.json()._embedded.trips;
        }).catch(error => {
          throw Error(error.json() && error.json().message);
        });
  }

  getTripById(id: number): Observable<Trip> {
    return this.http.get(`${environment.host}api/trips/${id}?projection=inline-route`)
      .map((res: Response) => {
        return res.json();
      }).catch(error => {
          throw Error(error.json() && error.json().message);
      })
  }

}
