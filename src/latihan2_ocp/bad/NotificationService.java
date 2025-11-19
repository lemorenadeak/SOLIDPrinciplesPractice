package latihan2_ocp.bad;

// Class ini MELANGGAR OCP
public class NotificationService {

    public void sendNotification(String message, String type, String recipient) {

        // ❌ VIOLATION: Hardcoded logic inside the service.
        // If you want to add "WhatsApp", you MUST modify this class
        // by adding another 'else if'.

        if (type.equals("EMAIL")) {
            System.out.println("Sending EMAIL to: " + recipient);
            System.out.println("Content: " + message);
        } else if (type.equals("SMS")) {
            System.out.println("Sending SMS to: " + recipient);
            System.out.println("Content: " + message);
        }

        // Imagine adding 10 more channels here (Telegram, Slack, PushNotif).
        // This method would become huge and fragile.
    }
}