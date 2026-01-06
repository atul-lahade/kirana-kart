import { makeAutoObservable, runInAction } from 'mobx'
import { RootStore } from './RootStore'
import { Cart } from '../types/cart.types'

export class CartStore {
  rootStore: RootStore
  cart: Cart | null = null
  isLoading = false
  error: string | null = null

  constructor(rootStore: RootStore) {
    this.rootStore = rootStore
    makeAutoObservable(this)
  }

  get itemCount(): number {
    return this.cart?.items.reduce((sum, item) => sum + item.quantity, 0) || 0
  }

  get totalAmount(): number {
    return this.cart?.totalAmount || 0
  }

  async fetchCart() {
    if (!this.rootStore.authStore.isAuthenticated) return

    this.isLoading = true
    this.error = null

    try {
      const cart = await cartApi.getCart()

      runInAction(() => {
        this.cart = cart
        this.isLoading = false
      })
    } catch (error: any) {
      runInAction(() => {
        this.error = error.response?.data?.message || 'Failed to fetch cart'
        this.isLoading = false
      })
    }
  }

  async addItem(productId: string, quantity: number) {
    this.isLoading = true
    this.error = null

    try {
      const cart = await cartApi.addItem(productId, quantity)

      runInAction(() => {
        this.cart = cart
        this.isLoading = false
      })

      this.rootStore.uiStore.showToast('Item added to cart', 'success')
    } catch (error: any) {
      runInAction(() => {
        this.error = error.response?.data?.message || 'Failed to add item'
        this.isLoading = false
      })
      this.rootStore.uiStore.showToast(this.error!, 'error')
      throw error
    }
  }

  async updateItemQuantity(itemId: string, quantity: number) {
    this.isLoading = true
    this.error = null

    try {
      const cart = await cartApi.updateItemQuantity(itemId, quantity)

      runInAction(() => {
        this.cart = cart
        this.isLoading = false
      })
    } catch (error: any) {
      runInAction(() => {
        this.error = error.response?.data?.message || 'Failed to update quantity'
        this.isLoading = false
      })
      this.rootStore.uiStore.showToast(this.error!, 'error')
    }
  }

  async removeItem(itemId: string) {
    this.isLoading = true
    this.error = null

    try {
      const cart = await cartApi.removeItem(itemId)

      runInAction(() => {
        this.cart = cart
        this.isLoading = false
      })

      this.rootStore.uiStore.showToast('Item removed from cart', 'info')
    } catch (error: any) {
      runInAction(() => {
        this.error = error.response?.data?.message || 'Failed to remove item'
        this.isLoading = false
      })
      this.rootStore.uiStore.showToast(this.error!, 'error')
    }
  }

  clearCart() {
    this.cart = null
  }
}