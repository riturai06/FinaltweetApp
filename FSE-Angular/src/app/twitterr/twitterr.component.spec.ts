import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TwitterrComponent } from './twitterr.component';

describe('TwitterrComponent', () => {
  let component: TwitterrComponent;
  let fixture: ComponentFixture<TwitterrComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TwitterrComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TwitterrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
