import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostByCategoryComponent } from './post-by-category.component';

describe('PostByCategoryComponent', () => {
  let component: PostByCategoryComponent;
  let fixture: ComponentFixture<PostByCategoryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PostByCategoryComponent]
    });
    fixture = TestBed.createComponent(PostByCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
