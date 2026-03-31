package com.shravan;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public final class ResourceReader {
  private ResourceReader() {
  }

  public static String readText(String resourcePath) throws IOException {
    try (InputStream stream = ResourceReader.class.getResourceAsStream(resourcePath)) {
      if (stream == null) {
        throw new IOException("Resource not found: " + resourcePath);
      }
      return new String(stream.readAllBytes(), StandardCharsets.UTF_8);
    }
  }
}
