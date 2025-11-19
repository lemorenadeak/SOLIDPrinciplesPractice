package latihan3_lsp.good;

// Implementation yang FOLLOWS contract
public class EmailSender extends NotificationSender {

    public EmailSender() {
        super("EMAIL");
    }

    @Override
    public boolean send(String recipient, String message) {
        // Precondition check
        if (recipient == null || message == null) {
            return false;
        }

        // Simulation of sending logic
        System.out.println("[EmailSender] ✓ Notification sent to: " + recipient);
        return true;
    }
}