package latihan2_ocp;


import latihan2_ocp.good.*;
import java.util.*;

public class OCPPractice {
    public static void main(String[] args) {

        // ... (Keep the Bad Practice code as is for comparison) ...
        System.out.println("=== BAD PRACTICE: Melanggar OCP ===\n");
        latihan2_ocp.bad.NotificationService badService = new latihan2_ocp.bad.NotificationService();

        badService.sendNotification("Hello", "EMAIL", "user@example.com");
        badService.sendNotification("Hello", "SMS", "081234567890");
        System.out.println("\n" + "=".repeat(70));


        // ===== PART 2: GOOD PRACTICE - Mengikuti OCP =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti OCP ===\n");

        // 1. Setup the implementations we want to use
        List<NotificationSender> senders = new ArrayList<>();
        senders.add(new EmailSender());
        senders.add(new SmsSender());

        // 2. Adding a NEW feature (WhatsApp) requires ZERO changes to NotificationService
        // We just create the object and add it to the list.
        senders.add(new WhatsAppSender());

        // 3. Inject the list into the service
        NotificationService goodService = new NotificationService(senders);

        // 4. Run logic
        goodService.sendNotification("Hello Good OCP", "user@example.com");

        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Extensible - Mudah tambah channel baru");
        System.out.println("✓ Stable - Code existing tidak dimodifikasi");
    }
}