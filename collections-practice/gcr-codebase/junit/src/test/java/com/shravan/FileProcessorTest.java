package com.shravan;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class FileProcessorTest {

  @TempDir
  Path tempDir;

  @Test
  void testWriteAndReadFile() throws IOException {
    Path file = tempDir.resolve("testFile.txt");
    String content = "Hello JUnit";

    FileProcessor.writeToFile(file, content);
    String result = FileProcessor.readFromFile(file);

    assertEquals(content, result);
  }

  @Test
  void testFileExistsAfterWrite() throws IOException {
    Path file = tempDir.resolve("exists.txt");

    FileProcessor.writeToFile(file, "Check file");

    assertTrue(Files.exists(file));
  }

  @Test
  void testReadFromNonExistingFileThrowsException() {
    Path file = tempDir.resolve("missing.txt");

    assertThrows(IOException.class, () -> FileProcessor.readFromFile(file));
  }
}
