import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // Class-level annotation
@interface RoleAllowed {
  String value(); // Required role
}

class SecurityContext {

  private static String currentUserRole;

  public static void setRole(String role) {
    currentUserRole = role;
  }

  public static String getRole() {
    return currentUserRole;
  }
}

@RoleAllowed("ADMIN")
class AdminService {

  public void deleteUser() {
    System.out.println("User deleted successfully!");
  }
}

public class RoleBasedAnnotation {

  public static void main(String[] args) throws Exception {

    SecurityContext.setRole("ADMIN");

    AdminService service = new AdminService();
    Class<?> clazz = service.getClass();

    // Check class-level annotation
    if (clazz.isAnnotationPresent(RoleAllowed.class)) {

      RoleAllowed roleAllowed = clazz.getAnnotation(RoleAllowed.class);
      String requiredRole = roleAllowed.value();
      String currentRole = SecurityContext.getRole();

      if (!requiredRole.equals(currentRole)) {
        System.out.println("Access Denied!");
        return;
      }
    }

    // Access granted → invoke method
    Method method = clazz.getMethod("deleteUser");
    method.invoke(service);
  }

}
