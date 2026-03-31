package com.shravan;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessor {

  public static void writeToFile(Path file, String content) throws IOException {
    Files.writeString(file, content);
  }

  public static String readFromFile(Path file) throws IOException {
    return Files.readString(file);
  }
}
