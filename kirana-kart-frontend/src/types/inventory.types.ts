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

export type InventoryTransactionType = 'PURCHASE' | 'SALE' | 'ADJUSTMENT' | 'RETURN';

export interface InventoryTransaction {
  id: string;
  productId: string;
  transactionType: InventoryTransactionType;
  quantityChange: number;
  quantityAfter: number;
  referenceId?: string;
  notes?: string;
  createdBy?: string;
  createdAt: string;
}

export interface CreateInventoryTransactionDto {
  productId: string;
  transactionType: InventoryTransactionType;
  quantityChange: number;
  referenceId?: string;
  notes?: string;
}