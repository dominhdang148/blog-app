import { Component, Input } from '@angular/core';
import { PostDetail } from 'src/app/core/model/post/post-detail';

@Component({
  selector: 'app-post-detail-item',
  templateUrl: './post-detail-item.component.html',
  styleUrls: ['./post-detail-item.component.css'],
})
export class PostDetailItemComponent {
  @Input() post!: PostDetail | null;
  @Input() loading!: boolean | null;
}
