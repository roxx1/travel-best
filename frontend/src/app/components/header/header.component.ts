import { Component, OnInit } from '@angular/core';

declare let $: any;

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  private slides: Array<any>

  constructor() {
  }

  ngOnInit() {
  }

  onScrollToContent() {
    $(window).scrollTop($(window).height() - $(window).height()/10);
  }

}
