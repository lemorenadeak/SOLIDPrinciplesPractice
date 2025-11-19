package latihan3_lsp.bad;

public abstract class NotificationSender {
    protected String senderName;

    public NotificationSender(String senderName) {
        this.senderName = senderName;
    }

    // The Contract:
    // The application assumes this method performs an action and returns a boolean.
    // It does NOT expect a crash (Exception).
    public abstract boolean send(String recipient, String message);

    public String getType() {
        return senderName;
    }
}