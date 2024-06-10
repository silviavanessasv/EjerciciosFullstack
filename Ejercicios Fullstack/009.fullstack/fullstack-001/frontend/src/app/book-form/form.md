    save() {

      // Opción 1: extraer los valores del formulario manualmente uno por uno
      const book: Book = {
        id: this.bookForm.get('id')?.value ?? 0,
        isbn: this.bookForm.get('isbn')?.value ?? '',
        price: this.bookForm.get('price')?.value ?? 0.0
      }
      console.log(book);

      // Opción 2: Equivalente a lo anterior pero en una sola línea de código
      const book2: Book = this.bookForm.value as Book;
      // console.log(book2);

      const url = 'http://localhost:8080/books';
      // OPCIÓN 1
      /*
      this.httpClient.post<Book>(url, book).subscribe(bookFromBackend => {
        console.log(bookFromBackend);
        // navegar hacia listado
        //this.router.navigate(['/books']);
        // navegar hacia detail
        this.router.navigate(['/books', bookFromBackend.id, 'detail']);
      }, error => {
        console.log(error);
        window.alert("Datos incorrectos");
      });
      */

      // OPCIÓN 2: para resolver el tachado (deprecated)
      this.httpClient.post<Book>(url, book).subscribe({
        next: (bookFromBackend) => this.router.navigate(['/books', bookFromBackend.id, 'detail']),
        error: (error) => window.alert("Datos incorrectos"),
      });

      /*
      this.httpClient.post<Book>(url, book).subscribe({
        // si todo va bien se ejecuta next
        next: () => {},
        // si todo va mal se ejecuta error
        error: () => {},
      });
      */



    }
