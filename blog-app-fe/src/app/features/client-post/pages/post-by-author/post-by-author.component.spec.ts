import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostByAuthorComponent } from './post-by-author.component';

describe('PostByAuthorComponent', () => {
  let component: PostByAuthorComponent;
  let fixture: ComponentFixture<PostByAuthorComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PostByAuthorComponent]
    });
    fixture = TestBed.createComponent(PostByAuthorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
