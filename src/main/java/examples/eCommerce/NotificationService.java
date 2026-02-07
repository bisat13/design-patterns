package examples.eCommerce;

import java.util.ArrayList;
import java.util.List;

class NotificationService {
    private final List<NotificationChannel> channels = new ArrayList<>();

    void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }

    void notify(User user, String message) {
        for (NotificationChannel channel : channels) {
            channel.send(message, user);
        }
    }
}
