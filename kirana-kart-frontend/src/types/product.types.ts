
export interface Category {
  id: string
  name: string
  slug: string
  description?: string
}

export interface ProductImage {
  id: string
  url: string
  altText?: string
  isPrimary: boolean
}

export interface Inventory {
  quantity: number
  lowStockThreshold: number
  inStock: boolean
}

export enum ProductStatus {
  ACTIVE = 'ACTIVE',
  INACTIVE = 'INACTIVE',
  OUT_OF_STOCK = 'OUT_OF_STOCK',
}

export interface ProductFilters {
  categoryId?: string
  minPrice?: number
  maxPrice?: number
  inStock?: boolean
  search?: string
  sortBy?: string
  sortOrder?: 'asc' | 'desc'
}

export interface PageResponse<T> {
  content: T[]
  pageNumber: number
  pageSize: number
  totalElements: number
  totalPages: number
  last: boolean
}

export interface ProductDimensions {
  length: number;
  width: number;
  height: number;
}

export interface Product {
  id: string;
  name: string;
  slug: string;
  description?: string;
  shortDescription?: string;
  sku: string;
  categoryId?: string;
  basePrice: number;
  salePrice?: number;
  costPrice?: number;
  isActive: boolean;
  isFeatured: boolean;
  weight?: number;
  dimensions?: ProductDimensions;
  metaTitle?: string;
  metaDescription?: string;
  metaKeywords?: string;
  createdAt: string;
  updatedAt: string;
}

export interface ProductImage {
  id: string;
  productId: string;
  imageUrl: string;
  altText?: string;
  displayOrder: number;
  isPrimary: boolean;
  createdAt: string;
}

export interface CreateProductDto {
  name: string;
  slug: string;
  description?: string;
  shortDescription?: string;
  sku: string;
  categoryId?: string;
  basePrice: number;
  salePrice?: number;
  costPrice?: number;
  weight?: number;
  dimensions?: ProductDimensions;
  metaTitle?: string;
  metaDescription?: string;
  metaKeywords?: string;
}

export interface UpdateProductDto {
  name?: string;
  slug?: string;
  description?: string;
  shortDescription?: string;
  categoryId?: string;
  basePrice?: number;
  salePrice?: number;
  costPrice?: number;
  isActive?: boolean;
  isFeatured?: boolean;
  weight?: number;
  dimensions?: ProductDimensions;
  metaTitle?: string;
  metaDescription?: string;
  metaKeywords?: string;
}

export interface ProductReview {
  id: string;
  productId: string;
  userId: string;
  rating: number;
  title?: string;
  comment?: string;
  isVerifiedPurchase: boolean;
  isApproved: boolean;
  helpfulCount: number;
  createdAt: string;
  updatedAt: string;
}

export interface CreateReviewDto {
  productId: string;
  rating: number;
  title?: string;
  comment?: string;
}

export interface UpdateReviewDto {
  rating?: number;
  title?: string;
  comment?: string;
}