package com.kirana_kart.backend.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Centralized error codes for the application
 * All error codes follow the pattern: CATEGORY_NUMBER
 * <p>
 * Categories:
 * - AUTH: Authentication and Authorization
 * - USER: User-related operations
 * - PROD: Product-related operations
 * - ORD: Order-related operations
 * - CART: Shopping cart operations
 * - INV: Inventory operations
 * - CAT: Category operations
 * - PAY: Payment operations
 * - DISC: Discount and coupon operations
 * - VAL: Validation errors
 * - FILE: File upload/download operations
 * - DB: Database operations
 * - EXT: External service integrations
 * - EMAIL: Email operations
 * - RES: Generic resource operations
 * - SYS: System-level errors
 */
@Getter
@RequiredArgsConstructor
public enum CommonErrorCodes {

    SUCCESS("SUCCESS_001", "Operation completed successfully"),
    FAILURE("FAILURE_001", "Operation failed"),
    // ==================== AUTHENTICATION & AUTHORIZATION ====================
    /**
     * Authentication failed - Invalid credentials
     */
    AUTH_AUTHENTICATION_FAILED("AUTH_001", "Authentication failed"),

    /**
     * Access denied - User doesn't have required permissions
     */
    AUTH_ACCESS_DENIED("AUTH_002", "Access denied"),

    /**
     * Invalid or expired JWT token
     */
    AUTH_INVALID_TOKEN("AUTH_003", "Invalid or expired token"),

    /**
     * Email already registered in the system
     */
    AUTH_EMAIL_ALREADY_EXISTS("AUTH_004", "Email already exists"),

    /**
     * Email verification failed or token expired
     */
    AUTH_EMAIL_VERIFICATION_FAILED("AUTH_005", "Email verification failed"),

    /**
     * Password reset token invalid or expired
     */
    AUTH_INVALID_RESET_TOKEN("AUTH_006", "Invalid password reset token"),

    /**
     * Account is locked or disabled
     */
    AUTH_ACCOUNT_LOCKED("AUTH_007", "Account is locked"),

    /**
     * Invalid refresh token
     */
    AUTH_INVALID_REFRESH_TOKEN("AUTH_008", "Invalid refresh token"),

    // ==================== USER OPERATIONS ====================
    /**
     * User not found with given identifier
     */
    USER_NOT_FOUND("USER_001", "User not found"),

    /**
     * User profile update failed
     */
    USER_UPDATE_FAILED("USER_002", "User update failed"),

    /**
     * Invalid user role
     */
    USER_INVALID_ROLE("USER_003", "Invalid user role"),

    /**
     * User account already verified
     */
    USER_ALREADY_VERIFIED("USER_004", "User already verified"),

    // ==================== PRODUCT OPERATIONS ====================
    /**
     * Product not found with given identifier
     */
    PRODUCT_NOT_FOUND("PROD_001", "Product not found"),

    /**
     * Product creation failed
     */
    PRODUCT_CREATE_FAILED("PROD_002", "Product creation failed"),

    /**
     * Product update failed
     */
    PRODUCT_UPDATE_FAILED("PROD_003", "Product update failed"),

    /**
     * Product deletion failed
     */
    PRODUCT_DELETE_FAILED("PROD_004", "Product deletion failed"),

    /**
     * Product SKU already exists
     */
    PRODUCT_SKU_EXISTS("PROD_005", "Product SKU already exists"),

    /**
     * Invalid product status
     */
    PRODUCT_INVALID_STATUS("PROD_006", "Invalid product status"),

    // ==================== ORDER OPERATIONS ====================
    /**
     * Order not found with given identifier
     */
    ORDER_NOT_FOUND("ORD_001", "Order not found"),

    /**
     * Order processing failed
     */
    ORDER_PROCESSING_FAILED("ORD_002", "Order processing failed"),

    /**
     * Order cancellation failed
     */
    ORDER_CANCELLATION_FAILED("ORD_003", "Order cancellation failed"),

    /**
     * Order already cancelled
     */
    ORDER_ALREADY_CANCELLED("ORD_004", "Order already cancelled"),

    /**
     * Order already delivered
     */
    ORDER_ALREADY_DELIVERED("ORD_005", "Order already delivered"),

    /**
     * Invalid order status transition
     */
    ORDER_INVALID_STATUS_TRANSITION("ORD_006", "Invalid order status transition"),

    /**
     * Order cannot be modified
     */
    ORDER_CANNOT_BE_MODIFIED("ORD_007", "Order cannot be modified"),

    // ==================== SHOPPING CART OPERATIONS ====================
    /**
     * Shopping cart not found
     */
    CART_NOT_FOUND("CART_001", "Shopping cart not found"),

    /**
     * Cart is empty
     */
    CART_EMPTY("CART_002", "Shopping cart is empty"),

    /**
     * Cart item not found
     */
    CART_ITEM_NOT_FOUND("CART_003", "Cart item not found"),

    /**
     * Invalid cart quantity
     */
    CART_INVALID_QUANTITY("CART_004", "Invalid cart quantity"),

    /**
     * Cart item already exists
     */
    CART_ITEM_ALREADY_EXISTS("CART_005", "Cart item already exists"),

    // ==================== INVENTORY OPERATIONS ====================
    /**
     * Product out of stock
     */
    INVENTORY_OUT_OF_STOCK("INV_001", "Product out of stock"),

    /**
     * Insufficient stock
     */
    INVENTORY_INSUFFICIENT_STOCK("INV_002", "Insufficient stock"),

    /**
     * Inventory update failed
     */
    INVENTORY_UPDATE_FAILED("INV_003", "Inventory update failed"),

    /**
     * Invalid inventory quantity
     */
    INVENTORY_INVALID_QUANTITY("INV_004", "Invalid inventory quantity"),

    // ==================== CATEGORY OPERATIONS ====================
    /**
     * Category not found
     */
    CATEGORY_NOT_FOUND("CAT_001", "Category not found"),

    /**
     * Category already exists
     */
    CATEGORY_ALREADY_EXISTS("CAT_002", "Category already exists"),

    /**
     * Category has associated products
     */
    CATEGORY_HAS_PRODUCTS("CAT_003", "Category has associated products"),

    /**
     * Invalid category hierarchy
     */
    CATEGORY_INVALID_HIERARCHY("CAT_004", "Invalid category hierarchy"),

    // ==================== PAYMENT OPERATIONS ====================
    /**
     * Payment processing failed
     */
    PAYMENT_FAILED("PAY_001", "Payment processing failed"),

    /**
     * Payment already processed
     */
    PAYMENT_ALREADY_PROCESSED("PAY_002", "Payment already processed"),

    /**
     * Invalid payment method
     */
    PAYMENT_INVALID_METHOD("PAY_003", "Invalid payment method"),

    /**
     * Payment amount mismatch
     */
    PAYMENT_AMOUNT_MISMATCH("PAY_004", "Payment amount mismatch"),

    /**
     * Payment gateway error
     */
    PAYMENT_GATEWAY_ERROR("PAY_005", "Payment gateway error"),

    // ==================== DISCOUNT & COUPON OPERATIONS ====================
    /**
     * Invalid or expired discount code
     */
    DISCOUNT_INVALID_CODE("DISC_001", "Invalid or expired discount code"),

    /**
     * Discount code already used
     */
    DISCOUNT_ALREADY_USED("DISC_002", "Discount code already used"),

    /**
     * Discount usage limit exceeded
     */
    DISCOUNT_USAGE_LIMIT_EXCEEDED("DISC_003", "Discount usage limit exceeded"),

    /**
     * Minimum order amount not met
     */
    DISCOUNT_MINIMUM_NOT_MET("DISC_004", "Minimum order amount not met"),

    /**
     * Discount not applicable to cart items
     */
    DISCOUNT_NOT_APPLICABLE("DISC_005", "Discount not applicable"),

    // ==================== VALIDATION ERRORS ====================
    /**
     * General validation error
     */
    VALIDATION_ERROR("VAL_001", "Validation error"),

    /**
     * Invalid input parameter
     */
    VALIDATION_INVALID_INPUT("VAL_002", "Invalid input parameter"),

    /**
     * Constraint violation
     */
    VALIDATION_CONSTRAINT_VIOLATION("VAL_003", "Constraint violation"),

    /**
     * Type mismatch error
     */
    VALIDATION_TYPE_MISMATCH("VAL_004", "Type mismatch"),

    /**
     * Missing required field
     */
    VALIDATION_MISSING_FIELD("VAL_005", "Missing required field"),

    /**
     * Invalid email format
     */
    VALIDATION_INVALID_EMAIL("VAL_006", "Invalid email format"),

    /**
     * Invalid phone number
     */
    VALIDATION_INVALID_PHONE("VAL_007", "Invalid phone number"),

    /**
     * Password too weak
     */
    VALIDATION_WEAK_PASSWORD("VAL_008", "Password too weak"),

    // ==================== FILE OPERATIONS ====================
    /**
     * File upload failed
     */
    FILE_UPLOAD_FAILED("FILE_001", "File upload failed"),

    /**
     * Unsupported file type
     */
    FILE_UNSUPPORTED_TYPE("FILE_002", "Unsupported file type"),

    /**
     * File size exceeded
     */
    FILE_SIZE_EXCEEDED("FILE_003", "File size exceeded"),

    /**
     * File not found
     */
    FILE_NOT_FOUND("FILE_004", "File not found"),

    /**
     * File deletion failed
     */
    FILE_DELETE_FAILED("FILE_005", "File deletion failed"),

    /**
     * Invalid file name
     */
    FILE_INVALID_NAME("FILE_006", "Invalid file name"),

    // ==================== DATABASE OPERATIONS ====================
    /**
     * Database operation failed
     */
    DATABASE_ERROR("DB_001", "Database operation failed"),

    /**
     * Duplicate resource found
     */
    DATABASE_DUPLICATE_ENTRY("DB_002", "Duplicate entry"),

    /**
     * Foreign key constraint violation
     */
    DATABASE_CONSTRAINT_VIOLATION("DB_003", "Constraint violation"),

    /**
     * Transaction failed
     */
    DATABASE_TRANSACTION_FAILED("DB_004", "Transaction failed"),

    /**
     * Connection timeout
     */
    DATABASE_CONNECTION_TIMEOUT("DB_005", "Database connection timeout"),

    // ==================== EXTERNAL SERVICE OPERATIONS ====================
    /**
     * External service call failed
     */
    EXTERNAL_SERVICE_ERROR("EXT_001", "External service error"),

    /**
     * External service timeout
     */
    EXTERNAL_SERVICE_TIMEOUT("EXT_002", "External service timeout"),

    /**
     * External service unavailable
     */
    EXTERNAL_SERVICE_UNAVAILABLE("EXT_003", "External service unavailable"),

    /**
     * Invalid external service response
     */
    EXTERNAL_SERVICE_INVALID_RESPONSE("EXT_004", "Invalid external service response"),

    // ==================== EMAIL OPERATIONS ====================
    /**
     * Email sending failed
     */
    EMAIL_SEND_FAILED("EMAIL_001", "Email sending failed"),

    /**
     * Invalid email template
     */
    EMAIL_INVALID_TEMPLATE("EMAIL_002", "Invalid email template"),

    /**
     * Email configuration error
     */
    EMAIL_CONFIG_ERROR("EMAIL_003", "Email configuration error"),

    // ==================== GENERIC RESOURCE OPERATIONS ====================
    /**
     * Generic resource not found
     */
    RESOURCE_NOT_FOUND("RES_001", "Resource not found"),

    /**
     * Resource already exists
     */
    RESOURCE_ALREADY_EXISTS("RES_002", "Resource already exists"),

    /**
     * Resource creation failed
     */
    RESOURCE_CREATE_FAILED("RES_003", "Resource creation failed"),

    /**
     * Resource update failed
     */
    RESOURCE_UPDATE_FAILED("RES_004", "Resource update failed"),

    /**
     * Resource deletion failed
     */
    RESOURCE_DELETE_FAILED("RES_005", "Resource deletion failed"),

    // ==================== SYSTEM ERRORS ====================
    /**
     * Internal server error
     */
    SYSTEM_INTERNAL_ERROR("SYS_001", "Internal server error"),

    /**
     * Service unavailable
     */
    SYSTEM_SERVICE_UNAVAILABLE("SYS_002", "Service unavailable"),

    /**
     * Configuration error
     */
    SYSTEM_CONFIG_ERROR("SYS_003", "Configuration error"),

    /**
     * Rate limit exceeded
     */
    SYSTEM_RATE_LIMIT_EXCEEDED("SYS_004", "Rate limit exceeded"),

    /**
     * Maintenance mode
     */
    SYSTEM_MAINTENANCE_MODE("SYS_005", "System under maintenance");

    private final String code;
    private final String description;

    /**
     * Find error code enum by code string
     *
     * @param code error code string
     * @return CommonErrorCodes enum or null if not found
     */
    public static CommonErrorCodes fromCode(String code) {
        for (CommonErrorCodes errorCode : values()) {
            if (errorCode.code.equals(code)) {
                return errorCode;
            }
        }
        return null;
    }

    /**
     * Check if error code exists
     *
     * @param code error code string
     * @return true if exists, false otherwise
     */
    public static boolean exists(String code) {
        return fromCode(code) != null;
    }

    /**
     * Get error code
     *
     * @return error code string
     */
    public String getCode() {
        return code;
    }

    /**
     * Get error description
     *
     * @return error description
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", code, description);
    }
}