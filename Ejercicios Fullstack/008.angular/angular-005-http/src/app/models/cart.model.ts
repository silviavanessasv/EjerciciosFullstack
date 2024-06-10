import { Product } from "./product.model";

export interface Cart {
  id: number;
  // Many To One: findByUser_id
  userId: number; // user: User
  date: Date;
  // One To Many
  products: ProductCart[];
}

export interface ProductCart {
  productId: number;
  quantity: number;
}
