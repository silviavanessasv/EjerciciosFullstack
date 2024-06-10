import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { Book } from '../model/book.model';

@Component({
  selector: 'app-book-form',
  standalone: true,
  imports: [ReactiveFormsModule, HttpClientModule],
  templateUrl: './book-form.component.html',
  styleUrl: './book-form.component.css'
})
export class BookFormComponent {

  bookForm = this.fb.group({
    id: [0],
    title: [''],
    price: [0.0],
    available: [true],
    publishDate: [new Date()],
    category: [],
    topics: [[]] // array vacío
  });

  constructor(private fb: FormBuilder, private httpClient: HttpClient) {}

  save() {
    console.log("Guardando book");

    // Extraer los valores de cada input escritos por el usuario
    const id = this.bookForm.get('id')?.value ?? 0;
    const title = this.bookForm.get('title')?.value ?? 'titulo por defecto';
    const price = this.bookForm.get('price')?.value ?? 0.0;
    const available = this.bookForm.get('available')?.value ?? false;
    const publishDate = this.bookForm.get('publishDate')?.value ?? new Date();
    const category = this.bookForm.get('category')?.value ?? 'category1';
    const topics = this.bookForm.get('topics')?.value ?? [];

    // Crear un objeto utilizando los valores extraídos
    const bookToSave: Book = {
      id: id,
      title: title,
      price: price,
      available: available,
      publishDate: publishDate,
      category: category,
      topics: topics
    }
    console.log(bookToSave);


    // Enviar el objeto a backend utilizando HttpClient
    // const url = 'http://localhost:8080/books';
    // this.httpClient.post<Book>(url, bookToSave).subscribe(book => console.log(book));

  }
}
