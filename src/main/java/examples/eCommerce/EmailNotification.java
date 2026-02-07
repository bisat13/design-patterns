package examples.eCommerce;

class EmailNotification implements NotificationChannel {
    public void send(String message, User user) {
        System.out.println("Email to " + user.email + ": " + message);
    }
}