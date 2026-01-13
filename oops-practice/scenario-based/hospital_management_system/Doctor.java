import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Doctor extends Person {

  private String specialization;
  private final Set<String> availableSlots;

  public Doctor(String doctorId, String name, String phone, String specialization) {
    super(doctorId, name, phone);
    setSpecialization(specialization);
    this.availableSlots = new HashSet<>();
  }

  public String getSpecialization() {
    return specialization;
  }

  public void setSpecialization(String specialization) {
    if (specialization == null || specialization.isBlank()) {
      throw new IllegalArgumentException("specialization cannot be empty");
    }
    this.specialization = specialization;
  }

  // Polymorphism hook (overridden by GeneralDoctor/SpecialistDoctor)
  public double calculateConsultationFee() {
    return 300.0;
  }

  public void addAvailableSlot(String slot) {
    if (slot == null || slot.isBlank()) {
      throw new IllegalArgumentException("slot cannot be empty");
    }
    availableSlots.add(slot);
  }

  public boolean isSlotAvailable(String slot) {
    return availableSlots.contains(slot);
  }

  public void reserveSlot(String slot) {
    availableSlots.remove(slot);
  }

  public void releaseSlot(String slot) {
    availableSlots.add(slot);
  }

  public Set<String> getAvailableSlots() {
    return Collections.unmodifiableSet(availableSlots);
  }

  @Override
  public String toString() {
    return getId() + " - " + getName() + " | " + specialization + " | Fee: Rs."
        + calculateConsultationFee();
  }
}
