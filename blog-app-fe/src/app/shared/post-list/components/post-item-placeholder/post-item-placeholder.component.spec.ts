import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostItemPlaceholderComponent } from './post-item-placeholder.component';

describe('PostItemPlaceholderComponent', () => {
  let component: PostItemPlaceholderComponent;
  let fixture: ComponentFixture<PostItemPlaceholderComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PostItemPlaceholderComponent]
    });
    fixture = TestBed.createComponent(PostItemPlaceholderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
