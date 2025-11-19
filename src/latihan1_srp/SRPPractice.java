package latihan1_srp;

// import latihan1_srp.bad.NotificationService as BadNotificationService; // <--- DELETE THIS
import latihan1_srp.good.*; // This imports the "Good" NotificationService

public class SRPPractice {
    public static void main(String[] args) {
        /*
         * LATIHAN 1: SINGLE RESPONSIBILITY PRINCIPLE (SRP)
         */

        // ===== PART 1: BAD PRACTICE - Melanggar SRP =====
        System.out.println("=== BAD PRACTICE: Melanggar SRP ===\n");

        // FIX: Use the full package name here instead of the alias
        latihan1_srp.bad.NotificationService badService = new latihan1_srp.bad.NotificationService();

        badService.sendNotification("Hello World", "EMAIL", "user@example.com");

        // ... rest of your code ...
    }
}