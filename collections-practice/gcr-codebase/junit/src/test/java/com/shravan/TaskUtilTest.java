package com.shravan;

import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class TaskUtilTest {
  @Test
  @Timeout(value = 2, unit = TimeUnit.SECONDS)
  void testLongRunningTaskTimeout() throws InterruptedException {
    TaskUtil.longRunningTask();
  }

  @Test
  void testWithAssertTimeout() {
    assertTimeout(Duration.ofSeconds(2), () -> TaskUtil.longRunningTask());
  }
}
