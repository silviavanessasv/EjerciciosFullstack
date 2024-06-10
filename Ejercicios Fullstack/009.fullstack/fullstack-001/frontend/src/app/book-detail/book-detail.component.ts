import { Component, OnInit } from '@angular/core';
import { Book } from '../model/book.model';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Rating } from '../model/rating.model';
import { NgbAlert, NgbAlertModule, NgbRatingModule } from '@ng-bootstrap/ng-bootstrap';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { AuthenticationService } from '../authentication/authentication.service';

@Component({
  selector: 'app-book-detail',
  standalone: true,
  imports: [RouterLink, NgbRatingModule, ReactiveFormsModule, NgbAlertModule],
  templateUrl: './book-detail.component.html',
  styleUrl: './book-detail.component.css'
})
export class BookDetailComponent implements OnInit{

  book: Book | undefined;
  ratings: Rating[] = [];
  ratingForm = new FormGroup({
    score: new FormControl(0),
    comment: new FormControl('')
  });
  showSuccessDeletedRating = false;
  showErrorDeletedRating = false;
  userId = 0;
  isAdmin = false;

  constructor(
    private activatedRoute: ActivatedRoute,
    private httpClient: HttpClient,
    private authService: AuthenticationService
  ) {
    this.authService.userId.subscribe(userId => this.userId = userId);
    this.authService.isAdmin.subscribe(isAdmin => this.isAdmin = isAdmin);

  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      const id = params['id'];

      if (!id) return;

      const url = 'http://localhost:8080/books/' + id;
      this.httpClient.get<Book>(url).subscribe(b => {
        this.book = b;
        this.loadRatings();
      });

    });
  }

  save() {
    const rating: Rating = {
      id: 0,
      score: this.ratingForm.get('score')?.value ?? 0,
      comment: this.ratingForm.get('comment')?.value ?? '',
      book: this.book
    };

    this.httpClient.post<Rating>('http://localhost:8080/ratings', rating).subscribe(rating => {
        this.ratingForm.reset();
        this.loadRatings();
    });

  }

  loadRatings() {
    if (!this.book) return;

    this.httpClient.get<Rating[]>('http://localhost:8080/ratings/filter-by-book/' + this.book?.id)
        .subscribe(ratings => this.ratings = ratings);
  }

  deleteRating(rating: Rating) {
    this.httpClient.delete('http://localhost:8080/ratings/' + rating.id)
    .subscribe({
      next: response => {
        this.loadRatings();
        this.showSuccessDeletedRating = true;
      },
      error: error => {
        this.showErrorDeletedRating = true;
      }
    });
  }

}
