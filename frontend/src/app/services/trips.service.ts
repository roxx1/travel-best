import { Injectable } from '@angular/core';

import { Trip } from '../models/trip.model';
import { Route } from '../models/route.model';

@Injectable()
export class TripsService {

  private trips = [
    new Trip(
      1, 200,
      new Route(1, "random title", "assets/imgs/slider/nature1.jpg", "The capital for French"),
      10, 2
    ),
    new Trip(
      2, 300,
      new Route(2, "random title", "assets/imgs/slider/nature2.jpg", "The capital for French"),
      10, 3
    ),
    new Trip(
      1, 600,
      new Route(3, "random title", "assets/imgs/slider/nature3.jpg", "The capital for French"),
      10, 4
    ),
    new Trip(
      1, 400,
      new Route(4, "random title", "assets/imgs/slider/nature4.jpg", "The capital for French"),
      10, 5
    ),
    new Trip(
      1, 800,
      new Route(5, "random title", "assets/imgs/slider/nature5.jpg", "The capital for French"),
      10, 6
    ),
  ];

  getTrips(): Array<Trip> {
    return this.trips;
  }

  getTripById(id: number): Trip {
    return this.trips.find(trip => trip.id === id);
  }

}
