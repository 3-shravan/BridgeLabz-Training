package policy_system;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PolicyManager {

  private Set<Policy> hashSet = new HashSet<>();
  private Set<Policy> linkedHashSet = new LinkedHashSet<>();
  private Set<Policy> treeSet = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));
  private Map<Integer, Policy> policyMap = new HashMap<>();

  // Add policy to all sets
  public void addPolicy(Policy policy) {
    hashSet.add(policy);
    linkedHashSet.add(policy);
    treeSet.add(policy);
    policyMap.put(policy.getPolicyNumber(), policy);
  }

  public Policy getPolicyByNumber(int policyNumber) {
    return policyMap.get(policyNumber);
  }

  public void policiesByHolder(String holderName) {
    policyMap.values().stream().filter(p -> p.getPolicyHolderName().equalsIgnoreCase(holderName))
        .forEach(System.out::println);
  }

  // Retrieve all unique policies
  public void displayAllPolicies() {
    hashSet.forEach(System.out::println);
  }

  // Policies expiring within next 30 days
  public void policiesExpiringSoon() {
    LocalDate now = LocalDate.now();
    LocalDate limit = now.plusDays(30);

    hashSet.stream().filter(p -> !p.getExpiryDate().isAfter(limit)).forEach(System.out::println);
  }

  // Policies by coverage type
  public void policiesByCoverage(String coverage) {
    hashSet.stream().filter(p -> p.getCoverageType().equalsIgnoreCase(coverage)).forEach(System.out::println);
  }

  // Find duplicate policies by policy number
  public void findDuplicatePolicies(List<Policy> policies) {
    Set<Integer> seen = new HashSet<>();
    policies.stream().filter(p -> !seen.add(p.getPolicyNumber())).forEach(System.out::println);
  }

  // Remove Expire Polcies
  public void removeExpiredPolicies() {
    LocalDate today = LocalDate.now();
    Iterator<Policy> iterator = hashSet.iterator();
    while (iterator.hasNext()) {
      Policy policy = iterator.next();
      if (policy.getExpiryDate().isBefore(today)) {
        iterator.remove();
        linkedHashSet.remove(policy);
        treeSet.remove(policy);
        policyMap.remove(policy.getPolicyNumber());
      }
    }
  }

  // Performance comparison
  public void performanceTest(Policy policy) {
    testSetPerformance("HashSet", hashSet, policy);
    testSetPerformance("LinkedHashSet", linkedHashSet, policy);
    testSetPerformance("TreeSet", treeSet, policy);
  }

  private void testSetPerformance(String name, Set<Policy> set, Policy policy) {
    long start, end;

    start = System.nanoTime();
    set.add(policy);
    end = System.nanoTime();
    System.out.println(name + " Add: " + (end - start));

    start = System.nanoTime();
    set.contains(policy);
    end = System.nanoTime();
    System.out.println(name + " Search: " + (end - start));

    start = System.nanoTime();
    set.remove(policy);
    end = System.nanoTime();
    System.out.println(name + " Remove: " + (end - start));

    System.out.println();
  }
}
