// Enums and Literal Types
export type UserRole = 'CUSTOMER' | 'ADMIN';
export type AddressType = 'SHIPPING' | 'BILLING';
export type OrderStatus = 'PENDING' | 'CONFIRMED' | 'PROCESSING' | 'SHIPPED' | 'DELIVERED' | 'CANCELLED' | 'REFUNDED';
export type PaymentStatus = 'PENDING' | 'PAID' | 'FAILED' | 'REFUNDED';
export type TransactionType = 'PURCHASE' | 'SALE' | 'ADJUSTMENT' | 'RETURN';
export type DiscountType = 'PERCENTAGE' | 'FIXED_AMOUNT';

// Users
export interface User {
  id: string;
  email: string;
  passwordHash: string;
  firstName: string;
  lastName: string;
  phone?: string;
  role: UserRole;
  isActive: boolean;
  emailVerified: boolean;
  createdAt: string;
  updatedAt: string;
}

export interface CreateUserDto {
  email: string;
  password: string;
  firstName: string;
  lastName: string;
  phone?: string;
  role?: UserRole;
}

export interface UpdateUserDto {
  firstName?: string;
  lastName?: string;
  phone?: string;
  isActive?: boolean;
}

// Addresses
export interface Address {
  id: string;
  userId: string;
  addressType: AddressType;
  streetAddress: string;
  city: string;
  state: string;
  postalCode: string;
  country: string;
  isDefault: boolean;
  createdAt: string;
  updatedAt: string;
}

export interface CreateAddressDto {
  addressType: AddressType;
  streetAddress: string;
  city: string;
  state: string;
  postalCode: string;
  country?: string;
  isDefault?: boolean;
}

export interface UpdateAddressDto extends Partial<CreateAddressDto> {}

// Categories
export interface Category {
  id: string;
  name: string;
  slug: string;
  description?: string;
  parentId?: string;
  imageUrl?: string;
  isActive: boolean;
  displayOrder: number;
  createdAt: string;
  updatedAt: string;
}

export interface CreateCategoryDto {
  name: string;
  slug: string;
  description?: string;
  parentId?: string;
  imageUrl?: string;
  displayOrder?: number;
}

export interface UpdateCategoryDto extends Partial<CreateCategoryDto> {
  isActive?: boolean;
}

// Products
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

export interface UpdateProductDto extends Partial<CreateProductDto> {
  isActive?: boolean;
  isFeatured?: boolean;
}

// Product Images
export interface ProductImage {
  id: string;
  productId: string;
  imageUrl: string;
  altText?: string;
  displayOrder: number;
  isPrimary: boolean;
  createdAt: string;
}

export interface CreateProductImageDto {
  productId: string;
  imageUrl: string;
  altText?: string;
  displayOrder?: number;
  isPrimary?: boolean;
}

// Inventory
export interface Inventory {
  id: string;
  productId: string;
  quantity: number;
  reservedQuantity: number;
  reorderLevel: number;
  reorderQuantity: number;
  lastRestockedAt?: string;
  createdAt: string;
  updatedAt: string;
}

export interface UpdateInventoryDto {
  quantity?: number;
  reservedQuantity?: number;
  reorderLevel?: number;
  reorderQuantity?: number;
}

// Inventory Transactions
export interface InventoryTransaction {
  id: string;
  productId: string;
  transactionType: TransactionType;
  quantityChange: number;
  quantityAfter: number;
  referenceId?: string;
  notes?: string;
  createdBy?: string;
  createdAt: string;
}

export interface CreateInventoryTransactionDto {
  productId: string;
  transactionType: TransactionType;
  quantityChange: number;
  referenceId?: string;
  notes?: string;
}

// Product Reviews
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

export interface CreateProductReviewDto {
  productId: string;
  rating: number;
  title?: string;
  comment?: string;
}

export interface UpdateProductReviewDto {
  rating?: number;
  title?: string;
  comment?: string;
}

// Shopping Cart
export interface ShoppingCart {
  id: string;
  userId?: string;
  sessionId?: string;
  createdAt: string;
  updatedAt: string;
}

// Cart Items
export interface CartItem {
  id: string;
  cartId: string;
  productId: string;
  quantity: number;
  priceAtAddition: number;
  createdAt: string;
  updatedAt: string;
}

export interface CreateCartItemDto {
  productId: string;
  quantity: number;
}

export interface UpdateCartItemDto {
  quantity: number;
}

// Orders
export interface Order {
  id: string;
  orderNumber: string;
  userId: string;
  status: OrderStatus;
  subtotal: number;
  taxAmount: number;
  shippingAmount: number;
  discountAmount: number;
  totalAmount: number;
  shippingAddressId?: string;
  shippingMethod?: string;
  trackingNumber?: string;
  billingAddressId?: string;
  paymentMethod?: string;
  paymentStatus: PaymentStatus;
  paymentIntentId?: string;
  paidAt?: string;
  shippedAt?: string;
  deliveredAt?: string;
  cancelledAt?: string;
  createdAt: string;
  updatedAt: string;
  customerNotes?: string;
  adminNotes?: string;
}

export interface CreateOrderDto {
  shippingAddressId: string;
  billingAddressId: string;
  paymentMethod: string;
  shippingMethod?: string;
  customerNotes?: string;
}

export interface UpdateOrderDto {
  status?: OrderStatus;
  paymentStatus?: PaymentStatus;
  trackingNumber?: string;
  adminNotes?: string;
}

// Order Items
export interface OrderItem {
  id: string;
  orderId: string;
  productId: string;
  productName: string;
  productSku: string;
  quantity: number;
  unitPrice: number;
  totalPrice: number;
  createdAt: string;
}

// Order Status History
export interface OrderStatusHistory {
  id: string;
  orderId: string;
  oldStatus?: OrderStatus;
  newStatus: OrderStatus;
  notes?: string;
  changedBy?: string;
  createdAt: string;
}

// Discount Codes
export interface DiscountCode {
  id: string;
  code: string;
  description?: string;
  discountType: DiscountType;
  discountValue: number;
  minOrderAmount?: number;
  maxDiscountAmount?: number;
  usageLimit?: number;
  usedCount: number;
  isActive: boolean;
  validFrom: string;
  validUntil: string;
  createdAt: string;
  updatedAt: string;
}

export interface CreateDiscountCodeDto {
  code: string;
  description?: string;
  discountType: DiscountType;
  discountValue: number;
  minOrderAmount?: number;
  maxDiscountAmount?: number;
  usageLimit?: number;
  validFrom: string;
  validUntil: string;
}

export interface UpdateDiscountCodeDto extends Partial<CreateDiscountCodeDto> {
  isActive?: boolean;
}

// Wishlist
export interface Wishlist {
  id: string;
  userId: string;
  productId: string;
  createdAt: string;
}

// Email Verification Tokens
export interface EmailVerificationToken {
  id: string;
  userId: string;
  token: string;
  expiresAt: string;
  createdAt: string;
}

// Password Reset Tokens
export interface PasswordResetToken {
  id: string;
  userId: string;
  token: string;
  expiresAt: string;
  createdAt: string;
}
