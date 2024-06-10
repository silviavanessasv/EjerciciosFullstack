import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Book } from '../model/book.model';
import { ActivatedRoute, Router } from '@angular/router';
import { Author } from '../model/author.model';
import { Editorial } from '../model/editorial.model';

@Component({
  selector: 'app-book-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './book-form.component.html',
  styleUrl: './book-form.component.css'
})
export class BookFormComponent implements OnInit {

  /*
  bookForm = this.fb.group({
    id: [0],
    isbn: [''],
    price: [0.0],
    author: this.fb.group({
      id: [0],
      fullName: [''],
      country: [''],
      active: [false]
    })
  });
  */
  bookForm = new FormGroup({
    id: new FormControl<number>(0),
    title: new FormControl<string>(''),
    isbn: new FormControl<string>(''),
    price: new FormControl<number>(0.0),
    published: new FormControl<boolean>(false),
    releaseDate: new FormControl<Date>(new Date()),
    author: new FormControl(),
    editorial: new FormControl(),
    type: new FormControl()
  });

  isUpdate: boolean = false; // por defecto estamos en CREAR no en ACTUALIZAR
  authors: Author[] = []; // array de autores para asociar un autor al libro
  editorials: Editorial[] = [];

  constructor(
      private fb: FormBuilder,
      private httpClient: HttpClient,
      private router: Router,
      private activatedRoute: ActivatedRoute) {
    }

    ngOnInit(): void {
      // cargar autores de backend para el selector de autores en el formulario
      this.httpClient.get<Author[]>('http://localhost:8080/authors')
      .subscribe(authors => this.authors = authors);

      this.httpClient.get<Editorial[]>('http://localhost:8080/editorials')
      .subscribe(editorials => this.editorials = editorials);

      this.activatedRoute.params.subscribe(params => {
        const id = params['id'];
        if(!id) return;

        this.httpClient.get<Book>('http://localhost:8080/books/' + id).subscribe(bookFromBackend => {
          // cargar el libro obtenido en el formulario bookForm
          this.bookForm.reset(bookFromBackend);

          // marcar boolean true isUpdate
          this.isUpdate = true;

        });
      });
    }

    save () {
      const book: Book = this.bookForm.value as Book;
      console.log(book);

      if (this.isUpdate) {
        const url = 'http://localhost:8080/books/' + book.id;
        this.httpClient.put<Book>(url, book).subscribe(bookFromBackend => {
          this.router.navigate(['/books', bookFromBackend.id, 'detail']);
        });

      } else {
        const url = 'http://localhost:8080/books';
        this.httpClient.post<Book>(url, book).subscribe(bookFromBackend => {
          this.router.navigate(['/books', bookFromBackend.id, 'detail']);
        });
      }
    }

    /*
    Función para los selectores del formulario.
    Permite precargar un objeto en un selector cuando se entra a editar en un formulario
    */
    compareObjects(o1: any, o2: any): boolean {
      // console.log("Comparando objetos: ", o1, o2);

      if(o1 && o2) {
        return o1.id === o2.id;
      }
      return o1 === o2;
    }


}
