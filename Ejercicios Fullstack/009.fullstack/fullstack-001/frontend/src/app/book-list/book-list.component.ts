import { Component, OnInit, TemplateRef } from '@angular/core';
import { Book } from '../model/book.model';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { RouterLink } from '@angular/router';
import { NgbAlertModule, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DatePipe } from '@angular/common';
import { AuthenticationService } from '../authentication/authentication.service';

@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [ RouterLink, NgbAlertModule, DatePipe],
  templateUrl: './book-list.component.html',
  styleUrl: './book-list.component.css'
})
export class BookListComponent implements OnInit{

  books: Book[] = [];
  showDeletedBookMessage: boolean = false;
  isAdmin = false;
  showSpinner = true;

  constructor(
    private httpClient: HttpClient,
    private authService: AuthenticationService,
    private modalService: NgbModal
  ) {
      this.authService.isAdmin.subscribe(isAdmin => this.isAdmin = isAdmin);
    }

  ngOnInit(): void {
    this.loadBooks();
  }
  delete(book: Book) {
    const url = 'http://localhost:8080/books/' + book.id;
    this.httpClient.delete(url).subscribe(response => {
      this.loadBooks();
      this.showDeletedBookMessage = true;
    }); // recarga los libros despues de borrar
  }
  hideDeletedBookMessage() {
    this.showDeletedBookMessage = false;
  }
  loadBooks() {
    const url = 'http://localhost:8080/books';
    this.httpClient.get<Book[]>(url).subscribe(books => {
      this.books = books;
      this.showSpinner = false;
    });
  }
  openModal(modal: TemplateRef<any>, book: Book) {
    this.modalService.open(modal, {
      centered: true
    }).result.then(result => {
      if (result === 'Aceptar') {
        this.delete(book);
      }
    });
  }
}
