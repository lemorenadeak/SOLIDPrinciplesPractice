package latihan3_lsp.bad;

public class ReadOnlySender extends NotificationSender {

    public ReadOnlySender() {
        super("READONLY");
    }

    @Override
    public boolean send(String recipient, String message) {
        // VIOLATION OF LSP:
        // The parent contract implies "sending" is a valid capability.
        // This child refuses to do it and throws an unexpected exception.
        // The client code (Main.java) is not prepared to catch this specific exception.
        throw new UnsupportedOperationException("This sender is read-only!");
    }
}