import { ProductFilters, PageResponse, Product } from '../types/product.types'
import { axiosInstance } from './axios.config'

export const productApi = {
  getProducts: async (
    page = 1,
    size = 20,
    filters?: ProductFilters
  ): Promise<PageResponse<Product>> => {
    const params = {
      page: page - 1,
      size,
      ...filters,
    }
    const response = await axiosInstance.get('/products', { params })
    return response.data
  },

  getProductById: async (id: string): Promise<Product> => {
    const response = await axiosInstance.get(`/products/${id}`)
    return response.data
  },

  searchProducts: async (query: string): Promise<Product[]> => {
    const response = await axiosInstance.get('/products/search', {
      params: { q: query },
    })
    return response.data
  },

  getProductsByCategory: async (categoryId: string): Promise<Product[]> => {
    const response = await axiosInstance.get(`/products/category/${categoryId}`)
    return response.data
  },
}