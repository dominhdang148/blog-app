import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Store } from '@ngrx/store';

@Component({
  selector: 'app-post-by-category',
  templateUrl: './post-by-category.component.html',
  styleUrls: ['./post-by-category.component.css'],
})
export class PostByCategoryComponent implements OnInit {
  slug!: string;
  constructor(
    private store: Store,
    private route: ActivatedRoute,
  ) {}
  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      this.slug = params.get('slug')!;
    });
  }
}
