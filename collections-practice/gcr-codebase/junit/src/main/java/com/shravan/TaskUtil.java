package com.shravan;

public class TaskUtil {

  public static String longRunningTask() throws InterruptedException {
    Thread.sleep(3000);
    return "Task Completed";
  }

}
