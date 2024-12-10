export interface ProductItem {
  id: number;
  productId: number;
  price: number;
  quantity: number;
  discount: number;
  product: {
    id: number;
    name: string;
    price: number;
    quantity: number;
  }
}
