import { Component, OnInit } from '@angular/core';

declare let $: any;

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    $('html, body').animate({scrollTop: $('.login').offset().top - 100 + 'px'}, 'fast');
  }

}
