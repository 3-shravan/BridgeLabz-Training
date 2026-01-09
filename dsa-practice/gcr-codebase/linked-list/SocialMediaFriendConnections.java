import java.util.Scanner;

class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String msg) {
    super(msg);
  }
}

class FriendNotFoundException extends RuntimeException {
  public FriendNotFoundException(String msg) {
    super(msg);
  }
}

class FriendNode {
  int friendId;
  FriendNode next;

  FriendNode(int friendId) {
    this.friendId = friendId;
  }
}

class UserNode {
  int userId;
  String name;
  int age;

  FriendNode friendsHead; // nested linked list
  UserNode next;

  UserNode(int userId, String name, int age) {
    this.userId = userId;
    this.name = name;
    this.age = age;
  }
}

class SocialMediaList {
  private UserNode head;

  void addUser(int id, String name, int age) {
    UserNode newUser = new UserNode(id, name, age);
    newUser.next = head;
    head = newUser;
  }

  UserNode searchById(int id) {
    UserNode temp = head;
    while (temp != null) {
      if (temp.userId == id)
        return temp;
      temp = temp.next;
    }
    throw new UserNotFoundException("User not found: " + id);
  }

  UserNode searchByName(String name) {
    UserNode temp = head;
    while (temp != null) {
      if (temp.name.equalsIgnoreCase(name))
        return temp;
      temp = temp.next;
    }
    throw new UserNotFoundException("User not found: " + name);
  }

  void addFriendConnection(int userId1, int userId2) {
    if (userId1 == userId2)
      return;

    UserNode u1 = searchById(userId1);
    UserNode u2 = searchById(userId2);

    addFriend(u1, userId2);
    addFriend(u2, userId1);
  }

  private void addFriend(UserNode user, int friendId) {
    FriendNode temp = user.friendsHead;
    while (temp != null) {
      if (temp.friendId == friendId)
        return; // avoid duplicates
      temp = temp.next;
    }

    FriendNode newFriend = new FriendNode(friendId);
    newFriend.next = user.friendsHead;
    user.friendsHead = newFriend;
  }

  void removeFriendConnection(int userId1, int userId2) {
    removeFriend(searchById(userId1), userId2);
    removeFriend(searchById(userId2), userId1);
  }

  private void removeFriend(UserNode user, int friendId) {
    FriendNode curr = user.friendsHead, prev = null;

    while (curr != null && curr.friendId != friendId) {
      prev = curr;
      curr = curr.next;
    }

    if (curr == null)
      throw new FriendNotFoundException("Friend not found: " + friendId);

    if (prev == null)
      user.friendsHead = curr.next;
    else
      prev.next = curr.next;
  }

  void findMutualFriends(int userId1, int userId2) {
    UserNode u1 = searchById(userId1);
    UserNode u2 = searchById(userId2);

    FriendNode f1 = u1.friendsHead;
    boolean found = false;

    System.out.print("Mutual Friends: ");

    while (f1 != null) {
      FriendNode f2 = u2.friendsHead;
      while (f2 != null) {
        if (f1.friendId == f2.friendId) {
          System.out.print(f1.friendId + " ");
          found = true;
        }
        f2 = f2.next;
      }
      f1 = f1.next;
    }

    if (!found)
      System.out.print("None");
    System.out.println();
  }

  void displayFriends(int userId) {
    UserNode user = searchById(userId);

    System.out.print("Friends of " + user.name + ": ");
    FriendNode temp = user.friendsHead;

    if (temp == null) {
      System.out.println("No friends");
      return;
    }

    while (temp != null) {
      System.out.print(temp.friendId + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  void countFriendsForAllUsers() {
    UserNode temp = head;

    while (temp != null) {
      int count = 0;
      FriendNode f = temp.friendsHead;
      while (f != null) {
        count++;
        f = f.next;
      }
      System.out.println("User " + temp.name + " has " + count + " friends");
      temp = temp.next;
    }
  }

}

public class SocialMediaFriendConnections {

  private static void printMenu() {
    System.out.println("\n==== Social Media Friend Connections ====");
    System.out.println("1. Add user");
    System.out.println("2. Search user (by id)");
    System.out.println("3. Search user (by name)");
    System.out.println("4. Add friend connection");
    System.out.println("5. Remove friend connection");
    System.out.println("6. Display friends of user");
    System.out.println("7. Find mutual friends");
    System.out.println("8. Count friends for all users");
    System.out.println("0. Exit");
  }

  private static int readInt(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim();
      try {
        return Integer.parseInt(input);
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid integer.");
      }
    }
  }

  private static String readNonEmptyString(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim();
      if (!input.isEmpty()) {
        return input;
      }
      System.out.println("Input cannot be empty.");
    }
  }

  private static void displayUser(UserNode user) {
    System.out.println("User ID: " + user.userId + ", Name: " + user.name + ", Age: " + user.age);
  }

  public static void main(String[] args) {
    SocialMediaList social = new SocialMediaList();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      printMenu();
      int choice = readInt(scanner, "Enter your choice: ");

      try {
        switch (choice) {
          case 1: {
            int id = readInt(scanner, "Enter user id: ");
            String name = readNonEmptyString(scanner, "Enter name: ");
            int age = readInt(scanner, "Enter age: ");
            social.addUser(id, name, age);
            System.out.println("User added.");
            break;
          }
          case 2: {
            int id = readInt(scanner, "Enter user id to search: ");
            UserNode user = social.searchById(id);
            displayUser(user);
            break;
          }
          case 3: {
            String name = readNonEmptyString(scanner, "Enter name to search: ");
            UserNode user = social.searchByName(name);
            displayUser(user);
            break;
          }
          case 4: {
            int userId1 = readInt(scanner, "Enter first user id: ");
            int userId2 = readInt(scanner, "Enter second user id: ");
            social.addFriendConnection(userId1, userId2);
            System.out.println("Friend connection added.");
            break;
          }
          case 5: {
            int userId1 = readInt(scanner, "Enter first user id: ");
            int userId2 = readInt(scanner, "Enter second user id: ");
            social.removeFriendConnection(userId1, userId2);
            System.out.println("Friend connection removed.");
            break;
          }
          case 6: {
            int userId = readInt(scanner, "Enter user id: ");
            social.displayFriends(userId);
            break;
          }
          case 7: {
            int userId1 = readInt(scanner, "Enter first user id: ");
            int userId2 = readInt(scanner, "Enter second user id: ");
            social.findMutualFriends(userId1, userId2);
            break;
          }
          case 8: {
            social.countFriendsForAllUsers();
            break;
          }
          case 0: {
            System.out.println("Exiting...");
            scanner.close();
            return;
          }
          default:
            System.out.println("Invalid choice. Please try again.");
        }
      } catch (RuntimeException e) {
        System.out.println("Error: " + e.getMessage());
      }
    }
  }

}
