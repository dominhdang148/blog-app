import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Pagination } from 'src/app/core/model/pagination';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.css'],
})
export class PaginationComponent {
  @Input() pagination!: Pagination;
  @Output() pageChange = new EventEmitter<number>();

  onPageChange(newPage: number) {
    if (newPage >= 0 && newPage < this.pagination?.totalPages) {
      this.pageChange.emit(newPage);
    }
  }
  onTest() {
    console.log('It is still working');
  }
}
