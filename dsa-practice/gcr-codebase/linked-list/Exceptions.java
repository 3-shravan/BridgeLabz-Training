class EmptyListException extends RuntimeException {
  public EmptyListException(String message) {
    super(message);
  }
}

class NotFoundException extends RuntimeException {
  public NotFoundException(String message) {
    super(message);
  }
}

class InvalidPositionException extends RuntimeException {
  public InvalidPositionException(String message) {
    super(message);
  }
}
