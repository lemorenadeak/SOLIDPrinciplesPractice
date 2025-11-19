package latihan2_ocp.good;

import java.util.List;

public class NotificationService {

    private List<NotificationSender> senders;

    // Constructor Injection: We pass the capabilities (senders) IN,
    // rather than hardcoding them inside.
    public NotificationService(List<NotificationSender> senders) {
        this.senders = senders;
    }

    public void sendNotification(String message, String recipient) {
        // The OCP Magic: We iterate through the interface.
        // If we added a 'TelegramSender' to the list, this loop
        // handles it automatically without code changes.
        for (NotificationSender sender : senders) {
            sender.send(recipient, message);
        }
    }
}