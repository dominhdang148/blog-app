import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { map } from 'rxjs';

@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html',
  styleUrls: ['./search-form.component.css'],
})
export class SearchFormComponent implements OnInit {
  keyword: string = '';
  constructor(
    private route: ActivatedRoute,
    private router: Router,
  ) {}
  ngOnInit(): void {
    this.route.queryParams
      .pipe(map((params) => params['keyword'] || ''))
      .subscribe((kw) => {
        this.router.navigate([], {
          queryParams: { keyword: kw === '' ? null : kw },
          queryParamsHandling: 'merge',
        });
        this.keyword = kw;
      });
  }
  onSearchSubmit() {
    this.router.navigate([''], {
      queryParams: { keyword: this.keyword, page: null },
      queryParamsHandling: 'merge',
    });
  }
}
