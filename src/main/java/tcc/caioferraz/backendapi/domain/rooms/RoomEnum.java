package tcc.caioferraz.backendapi.domain.rooms;

import lombok.Getter;

@Getter
public enum RoomEnum {

  SINGLE("Casal"),
  COUPLE("Solteiro");

  private final String type;

  RoomEnum(String type) {
    this.type = type;
  }
}
