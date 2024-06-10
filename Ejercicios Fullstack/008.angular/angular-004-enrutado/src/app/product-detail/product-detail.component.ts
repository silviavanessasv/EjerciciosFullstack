import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../models/product.model';
import { NgbAccordionModule, NgbAlertModule, NgbCarouselModule } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-product-detail',
  standalone: true,
  // Agregar alerta de NgBootstrap
  imports: [NgbAlertModule, NgbAccordionModule, NgbCarouselModule],
  templateUrl: './product-detail.component.html',
  styleUrl: './product-detail.component.css'
})
export class ProductDetailComponent implements OnInit {

  // producto
  product: Product | undefined;
  // array de imágenes para el acordeón
  images: string[] = [
    "https://picsum.photos/id/944/900/500",
    "https://picsum.photos/id/1011/900/500",
    "https://picsum.photos/id/984/900/500",
  ];

  // Angular inyecta este objeto en nuestro componente
  constructor(private activatedRoute: ActivatedRoute) {}

  // Este metodo es ejecutado por Angular automáticamente cuando un usuaro entra
  // en este componente. Sirve para cargar datos, llamar al backend, inicializar, config..
  ngOnInit(): void {
    console.log("Hola mundo");
    // Capturar el id de la url para saber qué producto es el que hay que cargar
    this.activatedRoute.params.subscribe(params => {
      console.log(params);
      console.log(params['id']); // id es el nombre que asignamos en app.routes.ts

      // Aquí obtendríamos un product de backend, vamos a crear uno manualmente:

      this.product = {
        id: 1,
        title: 'product1',
        price: 40,
        available: false,
        publishDate: new Date(),
        imageUrl: 'https://picsum.photos/id/944/900/500'
      };


    });
  }

}
