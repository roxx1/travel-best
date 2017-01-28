import {
  Component,
  OnInit,
  ViewChild
} from '@angular/core';

import { Router } from '@angular/router';

import {
  PaginatePipe,
  PaginationService
} from 'ng2-pagination';

import { TripsService } from '../services/trips.service';
import { TripDetailsComponent } from './trip-details/trip-details.component';
import { Trip } from '../models/trip.model';

declare let $: any;

@Component({
  selector: 'app-trips',
  templateUrl: './trips.component.html',
  styleUrls: ['./trips.component.css'],
  providers: [TripsService]
})
export class TripsComponent implements OnInit {
  @ViewChild('details') private details: TripDetailsComponent;

  private trips: Array<Trip>;

  private term: string;

  constructor(
    private router: Router,
    private tripsService: TripsService
  ) {}

  ngOnInit() {
    $('html, body').animate({scrollTop: $('.row').offset().top + 'px'}, 'fast');

    this.term = "";

    this.trips = this.tripsService.getTrips();
  }

  buyNow(trip: Trip) {
    this.router.navigate(['/trips/', trip.id]);
  }

  addToShoppingCart(trip: Trip) {

  }

}
