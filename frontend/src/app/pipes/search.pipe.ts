import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'searchByTitle'
})
export class SearchPipe implements PipeTransform {

  transform(values, [term = '']) {
    if(!!values) {
      return values
        .map(value => this.addSearchPriority(value, term.trim().toLowerCase()))
        .filter(value => !!value)
        .sort((a, b) => a.priority - b.priority)
        .map(item => item.object);
    }
  }

  addSearchPriority(value, term) {
    value.route.title = value.route.title.trim().toLowerCase();
    let searchResult = value.route.title.search(term);
    if(searchResult !== -1) {
      return {
        priority: searchResult,
        object: value
      };
    } else {
      return null;
    }
  }
  
}