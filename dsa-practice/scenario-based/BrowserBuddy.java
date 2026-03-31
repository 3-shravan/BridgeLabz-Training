import java.util.Stack;

public class BrowserBuddy {

  static class PageNode {
    String url;
    PageNode next;
    PageNode prev;

    PageNode(String url) {
      this.url = url;

    }
  }

  static class BrowserTab {
    private PageNode currentPage;
    private Stack<PageNode> closedTabs = new Stack<>();

    public void visitPage(String url) {
      PageNode newPage = new PageNode(url);
      if (currentPage != null) {
        newPage.prev = currentPage;
        currentPage.next = newPage;
      }
      currentPage = newPage;
      System.out.println("Visited: " + url);
    }

    public void back() {
      if (currentPage == null || currentPage.prev == null) {
        System.out.println("No previous page");
        return;
      }
      currentPage = currentPage.prev;
      System.out.println("Went back to: " + currentPage.url);

    }

    public void forward() {
      if (currentPage == null || currentPage.next == null) {
        System.out.println("No next page");
        return;
      }
      currentPage = currentPage.next;
      System.out.println("Went forward to: " + currentPage.url);

    }

    public void closeTab() {
      if (currentPage == null) {
        System.out.println("No tab to close");
        return;
      }
      closedTabs.push(currentPage);
      System.out.println("Closed tab: " + currentPage.url);

      if (currentPage.prev != null) {
        currentPage = currentPage.prev;
        currentPage.next = null;
      } else {
        currentPage = null;
      }
    }

    public void restoreTab() {
      if (closedTabs.isEmpty()) {
        System.out.println("No tabs to restore");
        return;
      }
      PageNode restoredPage = closedTabs.pop();
      if (currentPage != null) {
        restoredPage.prev = currentPage;
        currentPage.next = restoredPage;
      }
      currentPage = restoredPage;
      System.out.println("Restored tab: " + currentPage.url);

    }

    public void printCurrentPage() {

      if (currentPage == null) {
        System.out.println("No current page");
      } else {
        System.out.println("Current page: " + currentPage.url);
      }
    }

    public void printAllPages() {
      PageNode temp = currentPage;
      while (temp != null && temp.prev != null) {
        temp = temp.prev;
      }
      System.out.print("All pages: ");
      while (temp != null) {
        System.out.print(temp.url + " ");
        temp = temp.next;
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {

    BrowserTab tab = new BrowserTab();

    tab.visitPage("google.com");
    tab.visitPage("github.com");
    tab.visitPage("stackoverflow.com");

    tab.back();
    tab.back();
    tab.forward();

    tab.closeTab();
    tab.printCurrentPage();

    tab.restoreTab();
    tab.printCurrentPage();
    tab.printAllPages();
  }

}
