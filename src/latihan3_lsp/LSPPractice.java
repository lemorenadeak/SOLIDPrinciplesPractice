package latihan3_lsp;

// 1. Import the "Good" classes normally (so we can use them easily in Part 2)
import latihan3_lsp.good.NotificationSender;
import latihan3_lsp.good.EmailSender;
import latihan3_lsp.good.SmsSender;

// 2. Import specific bad classes that don't have name conflicts
import latihan3_lsp.bad.ReadOnlySender;

public class LSPPractice {
    public static void main(String[] args) {
        /*
         * LATIHAN 3: LISKOV SUBSTITUTION PRINCIPLE (LSP)
         */

        // ===== PART 1: BAD PRACTICE - Melanggar LSP =====
        System.out.println("=== BAD PRACTICE: Melanggar LSP ===\n");

        // ERROR FIX: Use "Fully Qualified Name" (complete package path)
        // to distinguish from the "good" NotificationSender imported above.
        latihan3_lsp.bad.NotificationSender sender1 = new latihan3_lsp.bad.EmailSender();
        latihan3_lsp.bad.NotificationSender sender2 = new ReadOnlySender(); // PROBLEM!

        // Test sender1 (EmailSender)
        System.out.println("Testing EmailSender:");
        processNotification(sender1, "user@example.com", "Hello");

        // Test sender2 (ReadOnlySender)
        System.out.println("\nTesting ReadOnlySender:");
        try {
            processNotification(sender2, "user@example.com", "Hello");
        } catch (Exception e) {
            System.out.println("❌ Exception thrown: " + e.getClass().getSimpleName() +
                    ": " + e.getMessage());
            System.out.println("❌ Program crashed!");
        }

        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("ReadOnlySender melanggar LSP karena:");
        System.out.println("1. Parent NotificationSender promise: bisa send notification");
        System.out.println("2. ReadOnlySender: throw exception instead");
        System.out.println("3. Cannot substitute parent class safely");
        System.out.println("4. Breaks polymorphic code");
        System.out.println("\nIni MELANGGAR LSP: subclass tidak bisa replace parent!");

        System.out.println("\n" + "=".repeat(70));

        // ===== PART 2: GOOD PRACTICE - Mengikuti LSP =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti LSP ===\n");

        System.out.println("Testing dengan semua implementation:");

        // Because we imported the "good" classes at the top, we can use short names here
        NotificationSender goodSender1 = new EmailSender();
        NotificationSender goodSender2 = new SmsSender();

        // Semua sender bisa digunakan secara polymorphic dengan aman
        testSender(goodSender1, "user@example.com", "Hello");
        testSender(goodSender2, "081234567890", "Hello");

        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Predictable - Semua child class berperilaku sesuai ekspektasi");
        System.out.println("✓ Reliable - Tidak ada surprise behavior");
        System.out.println("✓ Interchangeable - Bisa ganti child class dengan aman");
        System.out.println("✓ Safe - Polymorphic code bekerja tanpa masalah");
    }

    // Helper method for BAD practice
    // Note: We must use the full path here too because the parameter is the BAD sender
    private static void processNotification(latihan3_lsp.bad.NotificationSender sender,
                                            String recipient, String message) {
        boolean success = sender.send(recipient, message);
        if (success) {
            System.out.println("✓ Notification sent successfully");
        } else {
            System.out.println("✗ Failed to send notification");
        }
    }

    // Helper method for GOOD practice
    // Note: Uses the imported GOOD NotificationSender
    private static void testSender(NotificationSender sender,
                                   String recipient, String message) {
        boolean success = sender.send(recipient, message);
        if (success) {
            System.out.println("  → Success!");
        }
    }
}