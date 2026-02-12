LLD Problem: Order Fulfillment System

Problem Statement

Design a distributed order fulfillment system for an e-commerce platform that handles the following workflow:
Payment Processing: Charge the customer's payment method
Inventory Reservation: Reserve items from warehouse inventory
Shipping: Create shipping label and schedule pickup
Notification: Send confirmation email to customer and notify delays
Timeout Handling: Cancel order if any step fails or takes too long (48 hours total)


Customer\
Invertory\
Shipping\
Notification → email\
Timeout → cancel or fail 48 hrs
