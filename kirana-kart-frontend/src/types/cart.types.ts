import { Product } from './product.types'

export interface Cart {
  id: string
  userId: string
  items: CartItem[]
  subtotal: number
  tax: number
  discount: number
  totalAmount: number
  createdAt: string
  updatedAt: string
}

export interface CartItem {
  id: string
  product: Product
  quantity: number
  price: number
  totalPrice: number
}

export interface AddToCartRequest {
  productId: string
  quantity: number
}