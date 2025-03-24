import { Component, Input } from '@angular/core';
import { PostItem } from 'src/app/core/model/post/post-item';

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['./post-list.component.css'],
})
export class PostListComponent {
  @Input() posts!: PostItem[] | null;
  @Input() loading!: boolean | null;
}
