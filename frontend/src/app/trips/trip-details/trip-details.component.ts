import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';

import { TripsService } from '../../services/trips.service';
import { Trip } from '../../models/trip.model';

declare let $: any;

@Component({
  selector: 'app-trip-details',
  templateUrl: './trip-details.component.html',
  styleUrls: ['./trip-details.component.css'],
  providers: [TripsService]
})
export class TripDetailsComponent implements OnInit {

  private currentTrip: Trip;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private tripsService: TripsService
  ) {}

  ngOnInit() {
    $('html, body').animate({scrollTop: $('.buy-now').offset().top - 100 + 'px'}, 'fast');
    $('select').material_select();
    $('.collapsible').collapsible();
    this.currentTrip = this.tripsService.getTripById(1);
  }

  buy() {
    this.router.navigate(['orders']);
  }

}
