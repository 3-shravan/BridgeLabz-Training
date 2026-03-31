import java.util.Arrays;
import java.util.List;

abstract class JobRole {

  private String roleName;

  protected JobRole(String roleName) {
    this.roleName = roleName;
  }

  public String getRoleName() {
    return roleName;
  }

  public abstract String requiredSkills();
}

class SoftwareEngineer extends JobRole {

  public SoftwareEngineer() {
    super("Software Engineer");
  }

  public String requiredSkills() {
    return "Java, DSA, System Design";
  }
}

class DataScientist extends JobRole {

  public DataScientist() {
    super("Data Scientist");
  }

  public String requiredSkills() {
    return "Python, ML, Statistics";
  }
}

class ProductManager extends JobRole {

  public ProductManager() {
    super("Product Manager");
  }

  public String requiredSkills() {
    return "Product Strategy, Communication";
  }
}

class Resume<T extends JobRole> {
  private T jobRole;
  private String candidateName;

  public Resume(T jobRole, String candidateName) {
    this.jobRole = jobRole;
    this.candidateName = candidateName;
  }

  public String getResumeDetails() {
    return candidateName + " applying for " + jobRole.getRoleName() + " requires skills: " + jobRole.requiredSkills();
  }
}

class ResumeScreeningService {
  public static void screenResume(List<? extends JobRole> roles) {
    for (JobRole role : roles) {
      System.out.println("Screening Role: " + role.getRoleName() + " | Required Skills: " + role.requiredSkills());
    }
  }
}

public class ResumeScreening {
  public static void main(String[] args) {

    Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer(), "Alice");
    Resume<DataScientist> dsResume = new Resume<>(new DataScientist(), "Bob");
    Resume<ProductManager> pmResume = new Resume<>(new ProductManager(), "Charlie");

    System.out.println(seResume.getResumeDetails());
    System.out.println(dsResume.getResumeDetails());
    System.out.println(pmResume.getResumeDetails());

    List<JobRole> roles = Arrays.asList(new SoftwareEngineer(), new DataScientist(), new ProductManager());
    ResumeScreeningService.screenResume(roles);

  }
}