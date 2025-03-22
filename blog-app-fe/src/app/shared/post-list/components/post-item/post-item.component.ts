import { Component, Input } from '@angular/core';
import { PostItem } from 'src/app/core/model/post/post-item';

@Component({
  selector: 'app-post-item',
  templateUrl: './post-item.component.html',
  styleUrls: ['./post-item.component.css'],
})
export class PostItemComponent {
  @Input() post!: PostItem;
}
