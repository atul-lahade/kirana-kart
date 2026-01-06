import { makeAutoObservable, runInAction } from 'mobx'
import { RootStore } from './RootStore'
import { authApi } from '../api/auth.api'
import { User, LoginRequest, RegisterRequest } from '../types/auth.types'
import { storage } from '../utils/storage'

export class AuthStore {
  rootStore: RootStore
  user: User | null = null
  accessToken: string | null = null
  refreshToken: string | null = null
  isAuthenticated = false
  isLoading = false
  error: string | null = null

  constructor(rootStore: RootStore) {
    this.rootStore = rootStore
    makeAutoObservable(this)
    this.initializeAuth()
  }

  private initializeAuth() {
    const token = storage.getAccessToken()
    const user = storage.getUser()

    if (token && user) {
      runInAction(() => {
        this.accessToken = token
        this.user = user
        this.isAuthenticated = true
      })
    }
  }

  async login(credentials: LoginRequest) {
    this.isLoading = true
    this.error = null

    try {
      const response = await authApi.login(credentials)

      runInAction(() => {
        this.accessToken = response.accessToken
        this.refreshToken = response.refreshToken
        this.isAuthenticated = true
        this.isLoading = false
      })

      storage.setAccessToken(response.accessToken)
      storage.setRefreshToken(response.refreshToken)

      await this.fetchCurrentUser()

      this.rootStore.uiStore.showToast('Login successful!', 'success')
    } catch (error: any) {
      runInAction(() => {
        this.error = error.response?.data?.message || 'Login failed'
        this.isLoading = false
      })
      this.rootStore.uiStore.showToast(this.error!, 'error')
      throw error
    }
  }

  async register(data: RegisterRequest) {
    this.isLoading = true
    this.error = null

    try {
      const response = await authApi.register(data)

      runInAction(() => {
        this.accessToken = response.accessToken
        this.refreshToken = response.refreshToken
        this.isAuthenticated = true
        this.isLoading = false
      })

      storage.setAccessToken(response.accessToken)
      storage.setRefreshToken(response.refreshToken)

      await this.fetchCurrentUser()

      this.rootStore.uiStore.showToast('Registration successful!', 'success')
    } catch (error: any) {
      runInAction(() => {
        this.error = error.response?.data?.message || 'Registration failed'
        this.isLoading = false
      })
      this.rootStore.uiStore.showToast(this.error!, 'error')
      throw error
    }
  }

  async fetchCurrentUser() {
    try {
      const user = await authApi.getCurrentUser()

      runInAction(() => {
        this.user = user
      })

      storage.setUser(user)
    } catch (error: any) {
      console.error('Failed to fetch current user:', error)
      this.logout()
    }
  }

  logout() {
    runInAction(() => {
      this.user = null
      this.accessToken = null
      this.refreshToken = null
      this.isAuthenticated = false
    })

    storage.clearAuth()
    this.rootStore.cartStore.clearCart()
    this.rootStore.uiStore.showToast('Logged out successfully', 'info')
  }

  async refreshAccessToken() {
    if (!this.refreshToken) {
      this.logout()
      return
    }

    try {
      const response = await authApi.refreshToken(this.refreshToken)

      runInAction(() => {
        this.accessToken = response.accessToken
      })

      storage.setAccessToken(response.accessToken)
    } catch (error) {
      console.error('Failed to refresh token:', error)
      this.logout()
    }
  }
}