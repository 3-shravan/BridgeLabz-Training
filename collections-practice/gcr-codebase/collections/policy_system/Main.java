package policy_system;

import java.time.LocalDate;
import java.util.*;

public class Main {
        public static void main(String[] args) {

                PolicyManager manager = new PolicyManager();

                Policy p1 = new Policy(101, "Alice", LocalDate.now().plusDays(20), "Health", 5000);

                Policy p2 = new Policy(102, "Bob", LocalDate.now().plusDays(60), "Auto", 3000);

                Policy p3 = new Policy(103, "Charlie", LocalDate.now().plusDays(10), "Home", 7000);

                Policy p4 = new Policy(101, "Alice Duplicate", LocalDate.now().plusDays(20), "Health", 5000);

                manager.addPolicy(p1);
                manager.addPolicy(p2);
                manager.addPolicy(p3);

                System.out.println("🔹 All Unique Policies");
                manager.displayAllPolicies();

                System.out.println("\n🔹 Policies Expiring Soon");
                manager.policiesExpiringSoon();

                System.out.println("\n🔹 Health Coverage Policies");
                manager.policiesByCoverage("Health");

                System.out.println("\n🔹 Duplicate Policies");
                manager.findDuplicatePolicies(List.of(p1, p2, p3, p4));

                System.out.println("\n🔹 Performance Comparison");
                manager.performanceTest(new Policy(200, "Test", LocalDate.now().plusDays(90), "Auto", 4000));

                System.out.println(manager.getPolicyByNumber(101));
                manager.policiesByHolder("Alice");

                manager.removeExpiredPolicies();

        }
}
