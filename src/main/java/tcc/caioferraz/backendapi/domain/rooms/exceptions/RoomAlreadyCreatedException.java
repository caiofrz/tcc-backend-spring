package tcc.caioferraz.backendapi.domain.rooms.exceptions;

public class RoomAlreadyCreatedException extends RuntimeException {
  public RoomAlreadyCreatedException(String message) {
    super(message);
  }
}
