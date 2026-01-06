import { createContext, useContext } from 'react'
import { AuthStore } from './AuthStore'
import { CartStore } from './CartStore'
import { ProductStore } from './ProductStore'
import { UIStore } from './UIStore'

export class RootStore {
  authStore: AuthStore
  productStore: ProductStore
  cartStore: CartStore
  uiStore: UIStore

  constructor() {
    this.authStore = new AuthStore(this)
    this.productStore = new ProductStore(this)
    this.cartStore = new CartStore(this)
    this.uiStore = new UIStore(this)
  }
}

const rootStore = new RootStore()

const RootStoreContext = createContext<RootStore>(rootStore)

export const useStore = () => {
  const context = useContext(RootStoreContext)
  if (!context) {
    throw new Error('useStore must be used within RootStoreProvider')
  }
  return context
}

export const RootStoreProvider = RootStoreContext.Provider

export default rootStore