import { Routes } from '@angular/router';
import { BookListComponent } from './book-list/book-list.component';
import { HomeComponent } from './home/home.component';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { BookFormComponent } from './book-form/book-form.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';

export const routes: Routes = [

  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'books',
    component: BookListComponent
  },
  {
    path: 'books/:id/detail',
    component: BookDetailComponent
  },
  {
    path: 'books/create',
    component: BookFormComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  }

];
