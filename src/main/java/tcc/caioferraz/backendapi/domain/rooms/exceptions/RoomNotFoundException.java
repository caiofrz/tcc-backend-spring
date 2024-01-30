package tcc.caioferraz.backendapi.domain.rooms.exceptions;

public class RoomNotFoundException extends RuntimeException {
  public RoomNotFoundException(String message) {
    super(message);
  }
}
