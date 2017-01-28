import { Component, OnInit } from '@angular/core';

declare let $: any;

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    $('html, body').animate({scrollTop: $('.signup').offset().top - 100 + 'px'}, 'fast');
  }

}
