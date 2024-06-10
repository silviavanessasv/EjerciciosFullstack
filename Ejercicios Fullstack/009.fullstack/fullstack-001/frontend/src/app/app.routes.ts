import { Routes } from '@angular/router';
import { BookListComponent } from './book-list/book-list.component';
import { BookDetailComponent } from './book-detail/book-detail.component';
import { BookFormComponent } from './book-form/book-form.component';
import { AuthorDetailComponent } from './author-detail/author-detail.component';
import { ReservationFormComponent } from './reservation-form/reservation-form.component';
import { AuthorListComponent } from './author-list/author-list.component';
import { AuthorFormComponent } from './author-form/author-form.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { userRoleGuard } from './authentication/user-role.guard';
import { AccountFormComponent } from './account-form/account-form.component';
import { AvatarFormComponent } from './avatar-form/avatar-form.component';
import { userLoggedInGuard } from './authentication/user-logged-in.guard';

export const routes: Routes = [
  {
    path: '',
    component: BookListComponent
  },
  // Listado de libros accesible para todo el mundo
  {
    path: 'books',
    component: BookListComponent
  },
  // Detalle de un libro accesible solo para usuarios autenticados
  {
    path: 'books/:id/detail',
    component: BookDetailComponent,
    canActivate: [userLoggedInGuard]
  },
  // Creación y actualización de libro accesible solo para usuarios con rol ADMIN
  {
    path: 'books/create',
    component: BookFormComponent,
    canActivate: [userRoleGuard]
  },
  {
    path: 'books/:id/update',
    component: BookFormComponent,
    canActivate: [userRoleGuard]
  },
  {
    path: 'books/:id/reserve',
    component: ReservationFormComponent
  },
  {
    path: 'authors/:id/detail',
    component: AuthorDetailComponent
  },
  {
    path: 'authors',
    component: AuthorListComponent
  },
  {
    path: 'authors/create',
    component: AuthorFormComponent
  },
  {
    path: 'authors/:id/update',
    component: AuthorFormComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'users/account',
    component: AccountFormComponent
  },
  {
    path: 'users/account/avatar',
    component: AvatarFormComponent
  }
];
