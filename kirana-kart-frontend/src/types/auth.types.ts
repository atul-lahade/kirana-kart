export interface User {
  id: string
  firstName: string
  lastName: string
  email: string
  phoneNumber?: string
  role: UserRole
  emailVerified: boolean
  active: boolean
  profileImageUrl?: string
  createdAt: string
  updatedAt: string
}

export enum UserRole {
  CUSTOMER = 'CUSTOMER',
  ADMIN = 'ADMIN',
  SELLER = 'SELLER',
  SUPPORT = 'SUPPORT',
}

export interface LoginRequest {
  email: string
  password: string
}

export interface RegisterRequest {
  firstName: string
  lastName: string
  email: string
  password: string
  phoneNumber?: string
}

export interface AuthResponse {
  accessToken: string
  refreshToken: string
  tokenType: string
}

export interface RefreshTokenRequest {
  refreshToken: string
}

export interface CreateUserDto {
  email: string;
  password: string;
  firstName: string;
  lastName: string;
  phone?: string;
}

export interface UpdateUserDto {
  firstName?: string;
  lastName?: string;
  phone?: string;
}