import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';
import { PostItem } from 'src/app/core/model/post/post-item';

@Component({
  selector: 'app-post-item',
  templateUrl: './post-item.component.html',
  styleUrls: ['./post-item.component.css'],
})
export class PostItemComponent {
  @Input() post!: PostItem;

  constructor(private router: Router) {}
  onClickReadDetail() {
    const postedDate: Date = new Date(this.post.postedDate);
    console.log(postedDate);
    this.router.navigate([
      '/blog/post',
      postedDate.getFullYear(),
      postedDate.getMonth() + 1,
      postedDate.getDate(),
      this.post.urlSlug,
    ]);
  }
}
