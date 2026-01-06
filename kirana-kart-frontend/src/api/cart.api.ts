import { Cart } from '../types/cart.types'
import { axiosInstance } from './axios.config'

export const cartApi = {
  getCart: async (): Promise<Cart> => {
    const response = await axiosInstance.get('/cart')
    return response.data
  },

  addItem: async (productId: string, quantity: number): Promise<Cart> => {
    const response = await axiosInstance.post('/cart/items', { productId, quantity })
    return response.data
  },

  updateItemQuantity: async (itemId: string, quantity: number): Promise<Cart> => {
    const response = await axiosInstance.put(`/cart/items/${itemId}`, { quantity })
    return response.data
  },

  removeItem: async (itemId: string): Promise<Cart> => {
    const response = await axiosInstance.delete(`/cart/items/${itemId}`)
    return response.data
  },

  clearCart: async (): Promise<void> => {
    await axiosInstance.delete('/cart')
  },
}