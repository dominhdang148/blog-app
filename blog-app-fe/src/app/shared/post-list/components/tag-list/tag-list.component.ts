import { Component, Input } from '@angular/core';
import { PostItem } from 'src/app/core/model/post/post-item';
import { TagItem } from 'src/app/core/model/tag/tag-item';

@Component({
  selector: 'app-tag-list',
  templateUrl: './tag-list.component.html',
  styleUrls: ['./tag-list.component.css'],
})
export class TagListComponent {
  @Input() tags!: TagItem[];
}
