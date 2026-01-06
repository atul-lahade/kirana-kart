import { LoginRequest, AuthResponse, RegisterRequest, User } from '../types/auth.types'
import { axiosInstance } from './axios.config'

export const authApi = {
  login: async (credentials: LoginRequest): Promise<AuthResponse> => {
    const response = await axiosInstance.post('/auth/login', credentials)
    return response.data
  },

  register: async (data: RegisterRequest): Promise<AuthResponse> => {
    const response = await axiosInstance.post('/auth/register', data)
    return response.data
  },

  logout: async (): Promise<void> => {
    await axiosInstance.post('/auth/logout')
  },

  getCurrentUser: async (): Promise<User> => {
    const response = await axiosInstance.get('/auth/me')
    return response.data
  },

  refreshToken: async (refreshToken: string): Promise<AuthResponse> => {
    const response = await axiosInstance.post('/auth/refresh', { refreshToken })
    return response.data
  },

  forgotPassword: async (email: string): Promise<void> => {
    await axiosInstance.post('/auth/forgot-password', { email })
  },

  resetPassword: async (token: string, newPassword: string): Promise<void> => {
    await axiosInstance.post('/auth/reset-password', { token, newPassword })
  },
}