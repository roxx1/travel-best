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

@Injectable()
export class TripsService {

  constructor(private http: Http) {}

  getTrips(): Observable<Array<Trip>> {
    return this.http.get("http://localhost:8080/api/trips")
        .map((res: Response) => {
          return res.json()._embedded.trips;
        }).catch(error => {
          throw Error(error.json() && error.json().message);
        });
  }

  getTripById(id: number): Observable<Trip> {
    return this.http.get(`http://localhost:8080/api/trips/${id}?projection=route`)
      .map((res: Response) => {
        return res.json();
      }).catch(error => {
          throw Error(error.json() && error.json().message);
      })
  }

}
