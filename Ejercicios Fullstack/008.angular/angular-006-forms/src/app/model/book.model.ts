export interface Book {
  id: number;
  title: string;
  price: number;
  available: boolean;
  publishDate: Date;
  // Selectores
  category: string;
  topics: string[]; // array de string
}
