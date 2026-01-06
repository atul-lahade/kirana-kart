import { makeAutoObservable, runInAction } from 'mobx'

import { RootStore } from './RootStore'
import { productApi } from '../api/product.api'
import { Product, ProductFilters } from '../types/product.types'

export class ProductStore {
  rootStore: RootStore
  products: Product[] = []
  selectedProduct: Product | null = null
  isLoading = false
  error: string | null = null
  currentPage = 1
  totalPages = 1
  totalItems = 0
  filters: ProductFilters = {}

  constructor(rootStore: RootStore) {
    this.rootStore = rootStore
    makeAutoObservable(this)
  }

  async fetchProducts(page = 1, filters?: ProductFilters) {
    this.isLoading = true
    this.error = null

    try {
      const response = await productApi.getProducts(page, 20, filters)

      runInAction(() => {
        this.products = response.content
        this.currentPage = response.pageNumber
        this.totalPages = response.totalPages
        this.totalItems = response.totalElements
        this.filters = filters || {}
        this.isLoading = false
      })
    } catch (error: any) {
      runInAction(() => {
        this.error = error.response?.data?.message || 'Failed to fetch products'
        this.isLoading = false
      })
    }
  }

  async fetchProductById(id: string) {
    this.isLoading = true
    this.error = null

    try {
      const product = await productApi.getProductById(id)

      runInAction(() => {
        this.selectedProduct = product
        this.isLoading = false
      })
    } catch (error: any) {
      runInAction(() => {
        this.error = error.response?.data?.message || 'Failed to fetch product'
        this.isLoading = false
      })
    }
  }

  clearSelectedProduct() {
    this.selectedProduct = null
  }

  setFilters(filters: ProductFilters) {
    this.filters = filters
    this.fetchProducts(1, filters)
  }

  clearFilters() {
    this.filters = {}
    this.fetchProducts(1)
  }
}