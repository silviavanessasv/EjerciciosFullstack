import { Component } from '@angular/core';
import { HolamundoComponent } from './holamundo/holamundo.component';
import { AdiosMundoComponent } from './adios-mundo/adios-mundo.component';
@Component({
  selector: 'app-root',
  standalone: true,
  // Agregar a imports los componentes que se quieran mostrar
  // por pantalla:
  imports: [HolamundoComponent, AdiosMundoComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Hola soy Alan';
}
