# Order Management System (LLD)

## Overview

This document describes the Low-Level Design (LLD) of a simplified **Order Management System** for an e-commerce / delivery platform.

The system allows customers to:
- Place orders with multiple items
- Pay using different payment methods
- Manage inventory reservations
- Assign delivery partners
- Track order lifecycle
- Receive notifications
- Handle failures, cancellations, and timeouts gracefully

The design follows **object-oriented principles**, emphasizes **loose coupling**, and is **easily extensible**.

---

## Functional Requirements

### User & Order Management
- Users can place orders containing one or more items
- Each order has a unique `orderId`
- Order lifecycle is tracked using controlled state transitions

### Inventory Management
- Maintain inventory for all items
- Reserve or deduct inventory when an order is placed
- Fail order gracefully if inventory is insufficient

### Payment Processing
- Support multiple payment methods:
    - Credit Card
    - UPI
    - Wallet
    - Net Banking
- Payment layer should be extensible
- Order proceeds only after successful payment

### Delivery & Pickup
- Assign delivery partner after payment success
- Support pickup scheduling
- Delivery partner can update delivery status

### Order Status Management
Supported states:
- CREATED
- PAYMENT_PENDING
- PAYMENT_SUCCESS
- INVENTORY_RESERVED
- DELIVERY_PARTNER_ASSIGNED
- PICKED_UP
- DELIVERED
- CANCELLED
- FAILED

All state transitions are validated.

### Notifications
- Send confirmation after successful order placement
- Notify on delays, failures, or cancellations
- Support multiple channels (Email, SMS, Push)

### Timeout & Failure Handling
- If any step fails, order is cancelled
- Orders auto-cancel after 48 hours if not completed
- On cancellation:
    - Release inventory
    - Trigger refund if payment completed
    - Notify customer

---

## Non-Functional Requirements

- Object-Oriented Design
- Loose coupling between modules
- High extensibility
- Concurrency-safe inventory handling

---

## High-Level Architecture

User
|
OrderService
|-- PaymentService
|-- InventoryService
|-- DeliveryService
|-- NotificationService

---